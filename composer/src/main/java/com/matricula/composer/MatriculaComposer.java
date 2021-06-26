package com.matricula.composer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matricula.models.Alumno;
import com.matricula.models.Matricula;
import com.matricula.service.IAlumnoService;
import com.matricula.service.ICursoService;

@Component
public class MatriculaComposer {

	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	public List<Matricula> findAllMatricula() {
		List<Matricula> matriculas = cursoService.findAllMatricula();				
//		matriculas = matriculas.stream().map(item -> {
//			Alumno alumno = alumnoService.findAlumno(item.getAlumnoId());
//			item.setAlumno(alumno);
//			return item;
//		}).collect(Collectors.toList());
//		return matriculas;
		
		return matriculas;
	}
}
