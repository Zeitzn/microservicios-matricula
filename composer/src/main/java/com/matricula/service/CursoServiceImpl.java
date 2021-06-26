package com.matricula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.clients.AlumnoFeignClient;
import com.matricula.clients.CursoFeignClient;
import com.matricula.models.Alumno;
import com.matricula.models.Curso;
import com.matricula.models.Matricula;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private CursoFeignClient cursoFeignClient;
	
	@Override
	public Curso findCursoById(int id) {
		return cursoFeignClient.findCursoById(id);
	}

	@Override
	public Matricula findMatriculaById(int idMatricula) {
		return cursoFeignClient.findMatriculaById(idMatricula);
	}

	@Override
	public List<Matricula> findAllMatricula() {
		return cursoFeignClient.findAllMatricula();
	}

}
