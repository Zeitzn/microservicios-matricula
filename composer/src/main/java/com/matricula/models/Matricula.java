package com.matricula.models;
import lombok.Data;
@Data
public class Matricula {
	private int id;	
	private Curso curso;
//	private int alumnoId;
	private Alumno alumno;
}
