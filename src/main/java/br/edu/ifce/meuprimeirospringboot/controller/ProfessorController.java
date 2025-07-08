package br.edu.ifce.meuprimeirospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifce.meuprimeirospringboot.beans.Professor;
import br.edu.ifce.meuprimeirospringboot.service.ProfessorService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public String listarProfessores(Model model) {
        model.addAttribute("professores", professorService.listarTodos());
        return "professor/lista";
    }

    @GetMapping("/novo")
    public String formularioNovoProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorService.buscarPorId(id);
        model.addAttribute("professor", professor);
        return "professor/formulario";
    }

    @PostMapping("/salvar")
    public String salvarProfessor(@Valid @ModelAttribute Professor professor, 
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "professor/formulario";
        }
        professorService.salvar(professor);
        return "redirect:/professores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.deletar(id);
        return "redirect:/professores";
    }
}