package com.onemoreapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationProvider authenticationProvider;
	
//	  @Override 
//	  protected void configure(AuthenticationManagerBuilder auth) throws
//	  Exception {
//	  
//	  InMemoryUserDetailsManager userDetailsService = new
//	  InMemoryUserDetailsManager(); UserDetails user =
//	  User.withUsername("gayab").password(passwordEncoder.encode("aya")).
//	  authorities("read").build(); userDetailsService.createUser(user); //
//	  auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//	  auth.userDetailsService(userDetailsService);
//	  
//	  }
	 
	 
	  @Override 
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  
		  auth.authenticationProvider(authenticationProvider);
	  }
	  
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
	
}
