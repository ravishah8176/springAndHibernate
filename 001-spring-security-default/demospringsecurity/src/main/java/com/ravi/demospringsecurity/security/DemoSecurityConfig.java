package com.ravi.demospringsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public UserDetailsManager theUserDetailsManager(DataSource datasource){
        JdbcUserDetailsManager theJdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

        theJdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        theJdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return theJdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain theSecurityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers("/").hasRole("EMPLOYEE")
                            .requestMatchers("/leaders/**").hasRole("MANAGER")
                            .requestMatchers("/systems/**").hasRole("ADMIN")
                            .anyRequest().authenticated()
            )
            .exceptionHandling(configurer ->
                    configurer
                            .accessDeniedPage("/" +
                                    "access-denied")
            )
            .formLogin(form ->
                    form
                            .loginPage("/showLoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll()
            )
        .logout(logout ->
                logout.permitAll()
        );

        return http.build();
    }

}



/*
@Bean
public InMemoryUserDetailsManager theUserDetailsManager(){

    UserDetails john = User.builder()
            .username("john")
            .password("{noop}test123")
            .roles("Employee")
            .build();

    UserDetails mary = User.builder()
            .username("mary")
            .password("{noop}test123")
            .roles("Employee", "Manager")
            .build();

    UserDetails susan = User.builder()
            .username("susan")
            .password("{noop}test123")
            .roles("Employee", "Manager", "Admin")
            .build();

    return new InMemoryUserDetailsManager(john, mary, susan);
}
 */
