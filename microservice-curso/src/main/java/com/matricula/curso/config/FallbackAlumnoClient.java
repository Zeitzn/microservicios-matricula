package com.matricula.curso.config;

import org.springframework.stereotype.Component;

import com.matricula.curso.client.IAlumnoClient;
import com.matricula.curso.model.Alumno;

@Component
public class FallbackAlumnoClient implements IAlumnoClient {

	
    @Override
    public Alumno findAlumno(int id) {
		Alumno al = Alumno.builder().nombres("Juan Perez").apellidos("Perez").id(0).build();
		return al;
    }
}
