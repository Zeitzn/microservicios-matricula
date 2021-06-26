package com.matricula.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import com.matricula.curso.config.MyRequestInterceptor;
import com.matricula.curso.config.UserFeignClientInterceptor;

import feign.RequestInterceptor;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableResourceServer
@OpenAPIDefinition(
		info=@Info(
				title = "Microservicio Curso",
				version = "1.0",
				description = "Microservicio para la administración de cursos"))
public class MicroserviceCursoApplication {

	public static void main(String[] args) {
		//Permite herdar el contexto, se usa para interceptar el token y encadenarlo a feing { requestTokenBearerInterceptor }
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		SpringApplication.run(MicroserviceCursoApplication.class, args);
	}
	
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {

	    return requestTemplate -> {

	        Object principal = SecurityContextHolder
	                .getContext()
	                .getAuthentication()
	                .getPrincipal();
	        
	        if (!principal.equals("anonymousUser")) {

	            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
	                    SecurityContextHolder.getContext().getAuthentication().getDetails();
	            System.out.println(details);
	            requestTemplate.header("Authorization", "bearer " + details.getTokenValue());
	        }
	    };
	}
	

	
}
