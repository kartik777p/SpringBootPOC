package com.nit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/getAllStudents").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/getAllProjects").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/getStudentById/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/getProjectById/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/addStudent").hasAnyRole("STUDENT")
		.antMatchers(HttpMethod.POST,"/addProject").hasAnyRole("ADMIN")//Any method called related to post
		.antMatchers(HttpMethod.PUT,"/updateStudent/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT,"/updateProject/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/deleteStudentById/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/deleteProjectById/**").hasAnyRole("ADMIN")
		.and()
		.csrf().disable();
	}
}
