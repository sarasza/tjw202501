package br.edu.ifce.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifce.meuprimeirospringboot.beans.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}