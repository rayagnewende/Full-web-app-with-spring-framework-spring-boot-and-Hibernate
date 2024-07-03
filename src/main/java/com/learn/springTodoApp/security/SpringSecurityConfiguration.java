package com.learn.springTodoApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	
	@Bean
	public InMemoryUserDetailsManager createUserDetails() {
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input); 
		UserDetails userDetais = User.builder()
				 .passwordEncoder(passwordEncoder)
				 .username("kabore")
				 .password("123456")
				 .roles("USER", "ADMIN")
				 .build(); 
		
		return new InMemoryUserDetailsManager(userDetais); 
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(); 
	}

}
