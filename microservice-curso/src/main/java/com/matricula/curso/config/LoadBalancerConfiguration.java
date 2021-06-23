package com.matricula.curso.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Configuration
public class LoadBalancerConfiguration {
	
//	private final CircuitBreakerRegistry registry;
//    private final FallbackAlumnoClient fallbackAlumnoClient;

//	@Bean
//	public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(
//			ConfigurableApplicationContext context) {
//		System.out.println("Configuring Load balancer to prefer same instance");
//		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withSameInstancePreference()
//				.build(context);
//	}

	@Bean
	ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
			LoadBalancerClientFactory loadBalancerClientFactory) {
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
		
//		return new CustomLoadBalancer(
//				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
		return new RandomLoadBalancer(
				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
	}
	
//	CIRCUIT BREAKER
//	@Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        CircuitBreaker circuitBreaker = registry.circuitBreaker(IAlumnoClient.SERVICE_NAME);
//        FeignDecorators decorators = FeignDecorators.builder()
//                .withCircuitBreaker(circuitBreaker)
//                .withFallback(fallbackAlumnoClient)
//                .build();
//        return Resilience4jFeign.builder(decorators);
//    }

}
