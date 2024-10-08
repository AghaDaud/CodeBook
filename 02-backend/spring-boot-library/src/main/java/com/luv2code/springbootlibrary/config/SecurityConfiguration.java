package com.luv2code.springbootlibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration {
			
			@Bean
			public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
				
				
				//Disable cross site Request Forgery 
				http.csrf().disable();
				//Protect endpoints at /api/<type>/secure
				http.authorizeRequests(configurer ->
					configurer
								.antMatchers("/api/books/secure/**",
										"/api/reviews/secure/**","/api/messages/secure/**","/api/admin/secure/**")
								.authenticated())
								.oauth2ResourceServer()
								.jwt();
				
					//ADD CORS filters
					http.cors();
					//Add content negotiation Strategy 
					http.setSharedObject(ContentNegotiationStrategy.class, 
							new HeaderContentNegotiationStrategy());
						//Force a non-empty response body for 401s to make response freindly
					Okta.configureResourceServer401ResponseBody(http);
						
				return http.build();
				
			}
				
	
}
	

