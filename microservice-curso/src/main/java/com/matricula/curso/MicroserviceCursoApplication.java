package com.matricula.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(
		info=@Info(
				title = "Microservicio Curso",
				version = "1.0",
				description = "Microservicio para la administración de cursos"))
public class MicroserviceCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCursoApplication.class, args);
	}

}
