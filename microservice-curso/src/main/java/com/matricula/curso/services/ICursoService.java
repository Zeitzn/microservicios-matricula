package com.matricula.curso.services;

import java.util.List;

import com.matricula.curso.entities.Curso;

public interface ICursoService {

	Curso register(Curso entity);
	
	Curso update(Curso entity);
	
	List<Curso> findAll();
	
	Curso findById(int id);
}
