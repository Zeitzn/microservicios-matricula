package com.matricula.curso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.matricula.curso.model.Alumno;

import lombok.Data;

@Table
@Entity
@Data
public class Matricula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@NotNull(message = "El alumno no debe ser vacío")
	@Column(name="alumno_id")
	private int alumnoId;
	
	@Transient
	private Alumno alumno;
	
	@Transient
	private String port;
}
