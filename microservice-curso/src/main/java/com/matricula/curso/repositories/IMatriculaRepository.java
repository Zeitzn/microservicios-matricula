package com.matricula.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matricula.curso.entities.Matricula;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Integer> {

}
