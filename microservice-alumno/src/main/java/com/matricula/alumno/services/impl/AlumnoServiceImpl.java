package com.matricula.alumno.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.matricula.alumno.entities.Alumno;
import com.matricula.alumno.repositories.IAlumnoRepository;
import com.matricula.alumno.services.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private IAlumnoRepository repository;
	
	@Value("${server.port}")
	private String puerto;

	@Override
	public Alumno register(Alumno entity) {
		Alumno alumno = repository.save(entity);
		alumno.setPort(puerto);
		return alumno;
	}

	@Override
	public Alumno update(Alumno entity) {
		Alumno alumno = repository.save(entity);
		alumno.setPort(puerto);
		return alumno;
	}

	@Override
	public List<Alumno> findAll() {
		List<Alumno> alumnos = repository.findAll();
		alumnos = alumnos.stream().map(x->{
			x.setPort(puerto);
			return x;
		}).collect(Collectors.toList());
		return alumnos;
	}

	@Override
	public Alumno findById(int id) {
		Alumno alumno =repository.findById(id).orElse(null);
		alumno.setPort(puerto);
		return alumno;
	}

}
