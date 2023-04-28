package com.humber.eap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.requestMatchers("/addemployee")
		.hasRole("ADMIN")
		
		.requestMatchers("/")
		.authenticated()
		
		.requestMatchers("/employee")
		.hasRole("USER");
		
		http.formLogin().permitAll();
		
        http.logout();
		
		return http.build();
		
	}
@Bean
public InMemoryUserDetailsManager userDetailsService() {
	UserDetails user = User.withDefaultPasswordEncoder()
			.username("user")
			.password("password")
			.roles("USER")
			.build();
	
	UserDetails admin =User.withDefaultPasswordEncoder()
			.username("admin")
			.password("password")
			.roles("ADMIN")
			.build();
	return new InMemoryUserDetailsManager(user,admin);
	}
@Bean
public WebSecurityCustomizer ignoreResources() {
	return (webSecurity) ->webSecurity.ignoring().requestMatchers("/permitted/*");
}
}