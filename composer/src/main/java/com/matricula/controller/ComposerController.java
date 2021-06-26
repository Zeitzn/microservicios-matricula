package com.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matricula.composer.MatriculaComposer;
import com.matricula.models.Matricula;

@RestController
public class ComposerController {

	@Autowired
	private MatriculaComposer matriculaComposer;
	
	@GetMapping("/matriculas")
	public List<Matricula> getMatriculas(){
		return matriculaComposer.findAllMatricula();
	}
}
