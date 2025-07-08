package br.edu.ifce.meuprimeirospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.ifce.meuprimeirospringboot.beans.Disciplina;
import br.edu.ifce.meuprimeirospringboot.service.DisciplinaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaService.listarTodos());
        return "disciplina/lista";
    }

    @GetMapping("/novo")
    public String formularioNovaDisciplina(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaService.buscarPorId(id);
        model.addAttribute("disciplina", disciplina);
        return "disciplina/formulario";
    }

    @PostMapping("/salvar")
    public String salvarDisciplina(@Valid @ModelAttribute Disciplina disciplina, 
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "disciplina/formulario";
        }
        disciplinaService.salvar(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletar(id);
        return "redirect:/disciplinas";
    }
}