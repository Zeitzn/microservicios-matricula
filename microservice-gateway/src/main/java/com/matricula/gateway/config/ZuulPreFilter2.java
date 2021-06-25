package com.matricula.gateway.config;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
public class ZuulPreFilter2 extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ZuulPreFilter2.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 2;
    
    RouteLocator routeLocator;

    public ZuulPreFilter2() {}
    
    public ZuulPreFilter2(RouteLocator routeLocator) {
    	this.routeLocator=routeLocator;
    }
    
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		RequestContext ctx = RequestContext.getCurrentContext();
		String path = ctx.getRequest().getRequestURI();
		String instanceId=this.routeLocator.getMatchingRoute(path).getLocation();
		
		LOGGER.info("Prefilter 2: Petición {} a {} de {}", request.getMethod(), request.getRequestURL().toString(), instanceId);		

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
