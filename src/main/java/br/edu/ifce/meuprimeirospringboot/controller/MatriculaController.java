package br.edu.ifce.meuprimeirospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifce.meuprimeirospringboot.beans.Matricula;
import br.edu.ifce.meuprimeirospringboot.service.MatriculaService;
import br.edu.ifce.meuprimeirospringboot.beans.Aluno;
import br.edu.ifce.meuprimeirospringboot.beans.Turma;
import br.edu.ifce.meuprimeirospringboot.service.AlunoService;
import br.edu.ifce.meuprimeirospringboot.service.TurmaService;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
    
    @Autowired
    private MatriculaService matriculaService;
    
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public String listarMatriculas(Model model) {
        model.addAttribute("matriculas", matriculaService.listarTodos());
        return "matricula/lista";
    }

    @GetMapping("/novo")
    public String formularioNovaMatricula(Model model) {
        Matricula matricula = new Matricula();
        List<Aluno> alunos = alunoService.listarTodos();
        List<Turma> turmas = turmaService.listarTodos();
        
        model.addAttribute("matricula", matricula);
        model.addAttribute("todosAlunos", alunos);
        model.addAttribute("todasTurmas", turmas);
        return "matricula/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarMatricula(@PathVariable Long id, Model model) {
        Matricula matricula = matriculaService.buscarPorId(id);
        List<Aluno> alunos = alunoService.listarTodos();
        List<Turma> turmas = turmaService.listarTodos();
        
        model.addAttribute("matricula", matricula);
        model.addAttribute("todosAlunos", alunos);
        model.addAttribute("todasTurmas", turmas);
        return "matricula/formulario";
    }

    @PostMapping("/salvar")
    public String salvarMatricula(@Valid @ModelAttribute Matricula matricula, 
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Aluno> alunos = alunoService.listarTodos();
            List<Turma> turmas = turmaService.listarTodos();
            
            model.addAttribute("todosAlunos", alunos);
            model.addAttribute("todasTurmas", turmas);
            return "matricula/formulario";
        }
        
        matriculaService.salvar(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMatricula(@PathVariable Long id) {
        matriculaService.deletar(id);
        return "redirect:/matriculas";
    }
}