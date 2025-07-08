package br.edu.ifce.meuprimeirospringboot.service;

import java.util.List;
import br.edu.ifce.meuprimeirospringboot.beans.Turma;

public interface TurmaService {
    List<Turma> listarTodos();
    Turma salvar(Turma turma);
    Turma buscarPorId(Long id);
    void deletar(Long id);
}