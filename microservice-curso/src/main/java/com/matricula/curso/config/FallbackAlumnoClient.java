package com.matricula.curso.config;

import org.springframework.stereotype.Component;

import com.matricula.curso.client.IAlumnoClient;
import com.matricula.curso.model.Alumno;

@Component
public class FallbackAlumnoClient implements IAlumnoClient {

//	public FallbackAlumnoClient(Exception e) {
//
//    }
	
    @Override
    public Alumno findAlumno(int id) {
    	System.out.println("FALLBAAAAAAAAAAAACK");
		Alumno al = Alumno.builder().nombres("Juan Perez").apellidos("Perez").id(0).build();
		return al;
    }
}
