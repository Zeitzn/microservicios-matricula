package com.matricula.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.matricula.models.Curso;
import com.matricula.models.Matricula;

@FeignClient(name = "microservice-curso")
public interface CursoFeignClient {
	@GetMapping(value = "/curso/findById/{id}")
	public Curso findCursoById(@PathVariable("id") int id);
	
	@GetMapping(value = "/matricula/findById/{id}")
	public Matricula findMatriculaById(@PathVariable("id") int id);
	
	@GetMapping(value = "/matricula/findAll")
	public List<Matricula> findAllMatricula();
}
