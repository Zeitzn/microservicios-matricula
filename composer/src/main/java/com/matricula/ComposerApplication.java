package com.matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import feign.RequestInterceptor;
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableResourceServer
public class ComposerApplication {

	public static void main(String[] args) {
		//Permite herdar el contexto, se usa para interceptar el token y encadenarlo a feing { requestTokenBearerInterceptor }
		SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
		SpringApplication.run(ComposerApplication.class, args);
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
