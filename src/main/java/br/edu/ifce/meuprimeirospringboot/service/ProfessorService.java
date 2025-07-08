package br.edu.ifce.meuprimeirospringboot.service;

import java.util.List;
import br.edu.ifce.meuprimeirospringboot.beans.Professor;

public interface ProfessorService {
    List<Professor> listarTodos();
    Professor salvar(Professor professor);
    Professor buscarPorId(Long id);
    void deletar(Long id);
}