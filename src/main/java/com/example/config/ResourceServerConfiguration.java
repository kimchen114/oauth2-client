package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    
    // @Override
    // public void configure(HttpSecurity http) throws Exception {
    // // @formatter:off
    // http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
    // // @formatter:on
    // }
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("client").stateless(true);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().antMatchers("/user","/me").permitAll().anyRequest().authenticated();
        http.anonymous().disable().requestMatchers().antMatchers("/user/**").and().authorizeRequests()
                .antMatchers("/user/**").access("hasRole('ADMIN')").and().exceptionHandling()
                .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
    
}
