package com.matricula.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matricula.curso.entities.Curso;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}
