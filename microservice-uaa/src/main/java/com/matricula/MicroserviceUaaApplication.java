package com.matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@EnableEurekaClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
//@EnableResourceServer
public class MicroserviceUaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUaaApplication.class, args);
	}

}
