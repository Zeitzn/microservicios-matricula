package com.matricula.service;

import java.util.List;

import com.matricula.models.Curso;
import com.matricula.models.Matricula;

public interface ICursoService {
	Curso findCursoById(int id);
	
	Matricula findMatriculaById(int idMatricula);
	
	List<Matricula> findAllMatricula();
}
