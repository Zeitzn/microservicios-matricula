package com.matricula.curso.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.matricula.curso.config.FallbackAlumnoClient;
import com.matricula.curso.config.LoadBalancerConfiguration;
import com.matricula.curso.model.Alumno;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = IAlumnoClient.SERVICE_NAME, fallback = FallbackAlumnoClient.class)
//@CircuitBreaker(name = IAlumnoClient.SERVICE_NAME)
@LoadBalancerClient(name = IAlumnoClient.SERVICE_NAME, configuration = LoadBalancerConfiguration.class)
public interface IAlumnoClient {

	String SERVICE_NAME = "microservice-alumno";
	Logger LOGGER = LoggerFactory.getLogger(IAlumnoClient.class);

	@GetMapping(value = "/alumno/findById/{id}")
	public Alumno findAlumno(@PathVariable("id") int id);

}
