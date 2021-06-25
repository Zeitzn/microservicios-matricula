package com.matricula.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;

import com.matricula.gateway.config.CustomFallbackProvider;
import com.matricula.gateway.config.ZuulPostFilter;
import com.matricula.gateway.config.ZuulPreFilter;
import com.matricula.gateway.config.ZuulPreFilter2;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}
	
	@Bean
	public ZuulPreFilter prefilter1() {
		return new ZuulPreFilter();
	}
	
	@Bean
	public ZuulPreFilter2 prefilter2(RouteLocator routeLocator) {
		return new ZuulPreFilter2(routeLocator);
	}
	
	@Bean
	public ZuulPostFilter postfilter() {
		return new ZuulPostFilter();
	}
	
	@Bean
	public CustomFallbackProvider miPreFiltro() {
		return new CustomFallbackProvider();
	}

}
