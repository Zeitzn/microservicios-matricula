package com.matricula.alumno.services;

import java.util.List;

import com.matricula.alumno.entities.Alumno;

public interface IAlumnoService {

	Alumno register(Alumno entity);
	
	Alumno update(Alumno entity);
	
	List<Alumno> findAll();
	
	Alumno findById(int id);
}
