package com.matricula.curso.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.matricula.curso.client.IAlumnoClient;
import com.matricula.curso.entities.Matricula;
import com.matricula.curso.model.Alumno;
import com.matricula.curso.repositories.IMatriculaRepository;
import com.matricula.curso.services.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private IMatriculaRepository repository;
	
	@Autowired
    private IAlumnoClient alumnoClient;
	
	@Value("${server.port}")
	private String puerto;

	@Override
	public Matricula register(Matricula entity) {
		Matricula matricula = repository.save(entity);
		matricula.setPort(puerto);
		return matricula;
	}

	@Override
	public Matricula update(Matricula entity) {
		Matricula matricula = repository.save(entity);
		matricula.setPort(puerto);
		return matricula;
	}

	@Override
	public List<Matricula> findAll() {
		List<Matricula> matriculas=repository.findAll();
		
//		matriculas.forEach(item->{
//			Alumno alumno=alumnoClient.findAlumno(item.getAlumnoId()).getBody();
//			item.setAlumno(alumno);
//			item.setPort(puerto);
//		});
//		
		matriculas = matriculas.stream().map(item->{
			Alumno alumno=alumnoClient.findAlumno(item.getAlumnoId()).getBody();
			item.setAlumno(alumno);
			item.setPort(puerto);
			return item;
		}).collect(Collectors.toList());
		
		return matriculas;
	}

	@Override
	public Matricula findById(int id) {
		Matricula matricula=repository.findById(id).orElse(null);
		
		if(matricula!=null) {
			Alumno alumno=alumnoClient.findAlumno(matricula.getAlumnoId()).getBody();
			matricula.setAlumno(alumno);
			matricula.setPort(puerto);
		}
		return matricula;
	}

}
