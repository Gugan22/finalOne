package com.bidd.app.security;

import org.aspectj.apache.bcel.classfile.Module.Provide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private AuthEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private CustomAuthProvider authProvider;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth){
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		
		http
		.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(restAuthenticationEntryPoint) 
		.and()
		.antMatcher("/signUp")
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(getAuthenticationFilter())//this service for check login and custom authentication
		.logout();
	} 
	//this service for check login and custom authentication
	protected CustomAuthFilter getAuthenticationFilter() throws Exception {
		final	CustomAuthFilter filter = new CustomAuthFilter(authenticationManager());
		filter.setFilterProcessesUrl("/zetranApp/login");
		return filter;
	}

	
	
}
