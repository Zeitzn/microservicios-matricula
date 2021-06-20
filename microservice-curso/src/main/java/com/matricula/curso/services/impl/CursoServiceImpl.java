package com.matricula.curso.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.matricula.curso.entities.Curso;
import com.matricula.curso.repositories.ICursoRepository;
import com.matricula.curso.services.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private ICursoRepository repository;
	
	@Value("${server.port}")
	private String puerto;

	@Override
	public Curso register(Curso entity) {
		Curso curso = repository.save(entity);
		curso.setPort(puerto);
		return curso;
	}

	@Override
	public Curso update(Curso entity) {
		Curso curso = repository.save(entity);
		curso.setPort(puerto);
		return curso;
	}

	@Override
	public List<Curso> findAll() {
		List<Curso> cursos = repository.findAll();
		cursos = cursos.stream().map(x->{
			x.setPort(puerto);
			return x;
		}).collect(Collectors.toList());
		
		return cursos;
	}

	@Override
	public Curso findById(int id) {
		Curso curso = repository.findById(id).orElse(null);
		curso.setPort(puerto);
		return curso;
	}

}
