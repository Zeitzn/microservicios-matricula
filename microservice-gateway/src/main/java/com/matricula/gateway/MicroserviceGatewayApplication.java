package com.matricula.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.matricula.gateway.config.CustomFallbackProvider;
import com.matricula.gateway.config.ZuulPreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}
	
	@Bean
	public ZuulPreFilter prefilter() {
		return new ZuulPreFilter();
	}
	
	@Bean
	public CustomFallbackProvider miPreFiltro() {
		return new CustomFallbackProvider();
	}

}
