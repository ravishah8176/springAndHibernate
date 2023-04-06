package com.ravi.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	// hard code for accessing 

/*	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
						  .username("john")
						  .password("{noop}test123")
						  .roles("EMPLOYEE")
						  .build();
		
		UserDetails mary = User.builder()
						  .username("mary")
						  .password("{noop}test123")
						  .roles("EMPLOYEE", "MANAGER")
						  .build();
		
		UserDetails susan  = User.builder()
				           .username("susan")
				           .password("{noop}test123")
				           .roles("EMPLOYEE", "MANAGER", "ADMIN")
				           .build();
		
		return new InMemoryUserDetailsManager(john, mary, susan);
	}
*/
	
//	add support for JDBC  ... no more hardcoded users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager theJdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		// define query to retrieve a user by username
		theJdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
		
		// define authorities/role by username
		theJdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
		
		return theJdbcUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
			configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
		);
		
		// use HTTP basic authentication
		http.httpBasic();
		
		// disable cross site request forgery 
		// in general not required for state less REST APIs that use POST, PUT, DELETE and or PATCH
		http.csrf().disable();
		
		return http.build();		
	}
}





















