package com.matricula.gateway.config;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

//@Component
public class CustomFallbackProvider implements FallbackProvider {

	@Override
	public String getRoute() {
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		System.out.println("CAUSA DE FALLBACK");
		System.out.println(cause);
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		}else {
			return response(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
//				return new ByteArrayInputStream(getStatusText().concat(" fallback").getBytes());
				return new ByteArrayInputStream("{\"message\":\"Servicio no disponible. Fallback\"}".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub				
			}
		};
		
	}

}
