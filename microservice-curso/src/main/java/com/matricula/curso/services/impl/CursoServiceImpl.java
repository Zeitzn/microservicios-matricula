package com.matricula.curso.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.curso.entities.Curso;
import com.matricula.curso.repositories.ICursoRepository;
import com.matricula.curso.services.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private ICursoRepository repository;

	@Override
	public Curso register(Curso entity) {
		return repository.save(entity);
	}

	@Override
	public Curso update(Curso entity) {
		return repository.save(entity);
	}

	@Override
	public List<Curso> findAll() {
		return repository.findAll();
	}

	@Override
	public Curso findById(int id) {
		return repository.findById(id).orElse(null);
	}

}
