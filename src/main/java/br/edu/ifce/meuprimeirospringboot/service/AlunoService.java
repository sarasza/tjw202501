package br.edu.ifce.meuprimeirospringboot.service;

import java.util.List;
import br.edu.ifce.meuprimeirospringboot.beans.Aluno;

public interface AlunoService {
    List<Aluno> listarTodos();
    Aluno salvar(Aluno aluno);
    Aluno buscarPorId(Long id);
    void deletar(Long id);
}