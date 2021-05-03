package com.matricula.curso.services;

import java.util.List;

import com.matricula.curso.entities.Matricula;

public interface IMatriculaService {

	Matricula register(Matricula entity);
	
	Matricula update(Matricula entity);
	
	List<Matricula> findAll();
	
	Matricula findById(int id);
}
