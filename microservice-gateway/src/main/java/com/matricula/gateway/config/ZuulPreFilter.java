package com.matricula.gateway.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingRequestHeaderException;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.lang.reflect.Method;
//@Component
public class ZuulPreFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ZuulPreFilter.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;

    public ZuulPreFilter() {}
    
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
//		LOGGER.info("Petición {} a {}", request.getMethod(), request.getRequestURL().toString());		
		//Verificamos si recibimo el parámetro { app } en lso headers
		try {
			String app = request.getHeader("app");
			if(app.equals("web")) {
				//TODO Seguir el proceso
			}else {
				throw new ZuulException("El valor de app no es válido",HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
			}
		} catch (Exception e) {
			throw new ZuulException(e,HttpStatus.BAD_REQUEST.value(),e.getMessage());
		}
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	}

}
