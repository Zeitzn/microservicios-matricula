package com.matricula.curso.config;

import java.time.LocalDateTime;

import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyRequestInterceptor/* implements RequestInterceptor */{
/*
    private String jwt;
    private LocalDateTime expirationDate;

    @Override
    public void apply(RequestTemplate requestTemplate) {
//        if (LocalDateTime.now().isAfter(expirationDate)) {
//            requestToken();
//        }
    	ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        requestTemplate.header("Authorization: Bearer " + this.jwt);
    }
    */
}