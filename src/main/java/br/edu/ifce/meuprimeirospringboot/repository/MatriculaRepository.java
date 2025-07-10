package br.edu.ifce.meuprimeirospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifce.meuprimeirospringboot.beans.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}