package br.edu.ifce.meuprimeirospringboot.service;

import java.util.List;
import br.edu.ifce.meuprimeirospringboot.beans.Matricula;

public interface MatriculaService {
    List<Matricula> listarTodos();
    Matricula salvar(Matricula matricula);
    Matricula buscarPorId(Long id);
    void deletar(Long id);
}