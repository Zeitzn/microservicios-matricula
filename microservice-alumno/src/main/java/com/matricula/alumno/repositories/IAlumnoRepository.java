package com.matricula.alumno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matricula.alumno.entities.Alumno;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {

}
