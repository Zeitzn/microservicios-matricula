package com.matricula.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Alumno {
	
	private int id;

	private String nombres;

	private String apellidos;
}
