package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

import feign.RequestInterceptor;

//@Configuration
public class FeignConfiguration {

	@Autowired
	private CustomOauth2ClientContext customOauth2ClientContext;
	
	@Bean
	@Profile("dev")
	public  RequestInterceptor oauth2RequestInterceptorDev (OAuth2ClientContext oauth2ClientContext) {
		return new Oauth2RequestInterceptor(oauth2ClientContext,customOauth2ClientContext,resource());
	}
	
	@Bean
	public OAuth2ProtectedResourceDetails resource(){
		AuthorizationCodeResourceDetails resource= new AuthorizationCodeResourceDetails();
		resource.setAccessTokenUri("http://localhost:8080/oauth/token");
		resource.setClientId("client");
		resource.setClientSecret("secret");
		resource.setUserAuthorizationUri("http://localhost:8080/oauth/authorize");
		return resource;
	}
	
	
	
	
	
	
	
	
	
	
	
}
