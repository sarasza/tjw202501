package br.edu.ifce.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifce.meuprimeirospringboot.beans.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}