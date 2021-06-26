package com.matricula.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.clients.AlumnoFeignClient;
import com.matricula.models.Alumno;
@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private AlumnoFeignClient alumnoFeignClient;
	
	@Override
	public Alumno findById(int id) {
		return alumnoFeignClient.findAlumnoById(id);
	}

}
