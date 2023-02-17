package com.jaimecorg.springprojects.tienda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.jaimecorg.springprojects.tienda.services.UserService;

@Configuration
public class SecuriryConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserService myUserService(){
        return new  UserService();  
    }

    @Bean
    public UserDetailsService user(){

        UserDetails user = User.builder()
            .username("user")
            .password("{noop}user*1234")
            .authorities("USER")
            .build();

        UserDetails admin = User.builder()
            .username("admin")
            .password("{noop}admin*1234")
            .authorities("USER","ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = 
            new DaoAuthenticationProvider();

            authProvider.setUserDetailsService(myUserService());
            authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
            .authorizeRequests() //comprueba si te has logeado antes
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
        .and()
            .httpBasic();
            
        return http.build();
        
    }
}
