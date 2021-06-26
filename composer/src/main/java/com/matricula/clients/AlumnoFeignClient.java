package com.matricula.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.matricula.models.Alumno;

@FeignClient(name = "microservice-alumno")
public interface AlumnoFeignClient {
	
	@GetMapping(value = "/alumno/findById/{id}")
	public Alumno findAlumnoById(@PathVariable("id") int id);
}
