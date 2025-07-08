package br.edu.ifce.meuprimeirospringboot.service;

import java.util.List;
import br.edu.ifce.meuprimeirospringboot.beans.Disciplina;

public interface DisciplinaService {
    List<Disciplina> listarTodos();
    Disciplina salvar(Disciplina disciplina);
    Disciplina buscarPorId(Long id);
    void deletar(Long id);
}