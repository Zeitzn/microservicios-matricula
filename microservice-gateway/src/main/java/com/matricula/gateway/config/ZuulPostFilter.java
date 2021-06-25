package com.matricula.gateway.config;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
public class ZuulPostFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ZuulPostFilter.class);
    private static final String FILTERTYPE = "post";
    private static final Integer FILTERORDER = 3;

    public ZuulPostFilter() {}
    
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		final HttpServletRequest request = ctx.getRequest();		
		long startTime = (Long) ctx.get("startTime");
		LOGGER.info("Post filter::" + request.getMethod().toString() + ":: Tiempo de respuesta = " + (Instant.now().toEpochMilli() - startTime)+" milisegundos");
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
