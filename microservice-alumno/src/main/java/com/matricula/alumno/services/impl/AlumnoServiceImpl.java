package com.matricula.alumno.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.alumno.entities.Alumno;
import com.matricula.alumno.repositories.IAlumnoRepository;
import com.matricula.alumno.services.IAlumnoService;

@Service
public class CursoServiceImpl implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepository repository;

	@Override
	public Alumno register(Alumno entity) {
		return repository.save(entity);
	}

	@Override
	public Alumno update(Alumno entity) {
		return repository.save(entity);
	}

	@Override
	public List<Alumno> findAll() {
		return repository.findAll();
	}

	@Override
	public Alumno findById(int id) {
		return repository.findById(id).orElse(null);
	}

}
