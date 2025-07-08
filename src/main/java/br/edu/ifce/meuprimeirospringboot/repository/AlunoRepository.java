package br.edu.ifce.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifce.meuprimeirospringboot.beans.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}