package com.matricula.curso.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno {
	
	private int id;

	private String nombres;

	private String apellidos;
	
}
