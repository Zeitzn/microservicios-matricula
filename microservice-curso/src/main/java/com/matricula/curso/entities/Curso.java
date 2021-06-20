package com.matricula.curso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Table
@Entity
@Data
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "El nombre no debe ser vacío")
	@Column(length = 100)
	private String nombre;
	
	@Transient
	private String port;
}
