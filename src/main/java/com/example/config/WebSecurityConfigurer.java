//package com.example.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
//
//@Configuration
//@EnableOAuth2Sso
//public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // http.csrf().disable().headers().disable();
//        
//        // http.authorizeRequests().anyRequest().fullyAuthenticated();
//        // @formatter:off
//        http.authorizeRequests().antMatchers("/login**", "/webjars/**").permitAll().and().authorizeRequests()
//                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf()
//                .csrfTokenRepository(csrfTokenRepository()).and().headers().frameOptions().sameOrigin().and()
//                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
//        // .addFilterBefore(new JWTAuthenticationFilter(),
//        // UsernamePasswordAuthenticationFilter.class);
//        // @formatter:on
//    }
//    
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
//    }
//    
//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();
//        csrfTokenRepository.setHeaderName("XSRF-TOKEN");
//        return csrfTokenRepository;
//    }
//    
//    // @Override
//    // @Bean
//    // public AuthenticationManager authenticationManagerBean() throws Exception
//    // {
//    // return super.authenticationManagerBean();
//    // }
//    
//    // @Bean
//    // public OAuth2ClientAuthenticationProcessingFilter
//    // oauth2ClientAuthenticationProcessingFilter() {
//    // return new OAuth2ClientAuthenticationProcessingFilter("");
//    // }
//    
//}
