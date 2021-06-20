package com.matricula.alumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Microservicio Alumno",version = "1.0",description = "Microservicio para la administración de estudiantes"))
public class MicroserviceAlumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAlumnoApplication.class, args);
	}

}
