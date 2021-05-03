package com.matricula.alumno.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Table
@Entity
@Data
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "El nombre no debe ser vacío")
	@Column(length = 100)
	private String nombres;
	
	@NotEmpty(message = "El apellido no debe ser vacío")
	@Column(length = 100)
	private String apellidos;
}
