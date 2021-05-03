package com.matricula.curso.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.matricula.curso.model.Alumno;

@FeignClient(name = "microservice-alumno")
public interface IAlumnoClient {
	@GetMapping(value = "/alumno/findById/{id}")
    public ResponseEntity<Alumno> findAlumno(@PathVariable("id") int id);
}
