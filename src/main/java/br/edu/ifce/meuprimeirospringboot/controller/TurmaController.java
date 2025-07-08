package br.edu.ifce.meuprimeirospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.edu.ifce.meuprimeirospringboot.beans.Turma;
import br.edu.ifce.meuprimeirospringboot.service.TurmaService;
import br.edu.ifce.meuprimeirospringboot.beans.Disciplina;
import br.edu.ifce.meuprimeirospringboot.beans.Professor;
import br.edu.ifce.meuprimeirospringboot.service.DisciplinaService;
import br.edu.ifce.meuprimeirospringboot.service.ProfessorService;
import org.springframework.validation.BindingResult;


import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
    
    @Autowired
    private TurmaService turmaService;
    
    @Autowired
    private DisciplinaService disciplinaService;
    
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarTurmas(Model model) {
        model.addAttribute("turmas", turmaService.listarTodos());
        return "turma/lista";
    }

    @GetMapping("/novo")
    public String formularioNovaTurma(Model model) {
        Turma turma = new Turma();
        List<Disciplina> disciplinas = disciplinaService.listarTodos();
        List<Professor> professores = professorService.listarTodos();
        
        model.addAttribute("turma", turma);
        model.addAttribute("todasDisciplinas", disciplinas);
        model.addAttribute("todosProfessores", professores);
        return "turma/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarTurma(@PathVariable Long id, Model model) {
        Turma turma = turmaService.buscarPorId(id);
        List<Disciplina> disciplinas = disciplinaService.listarTodos();
        List<Professor> professores = professorService.listarTodos();
        
        model.addAttribute("turma", turma);
        model.addAttribute("todasDisciplinas", disciplinas);
        model.addAttribute("todosProfessores", professores);
        return "turma/formulario";
    }

    @PostMapping("/salvar")
    public String salvarTurma(@Valid @ModelAttribute Turma turma, 
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Disciplina> disciplinas = disciplinaService.listarTodos();
            List<Professor> professores = professorService.listarTodos();
            
            model.addAttribute("todasDisciplinas", disciplinas);
            model.addAttribute("todosProfessores", professores);
            return "turma/formulario";
        }
        
        turmaService.salvar(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarTurma(@PathVariable Long id) {
        turmaService.deletar(id);
        return "redirect:/turmas";
    }
}