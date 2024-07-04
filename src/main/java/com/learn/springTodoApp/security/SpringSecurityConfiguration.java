package com.learn.springTodoApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults ; 

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
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.authorizeHttpRequests( auth -> auth.anyRequest().authenticated()) ; 
		 http.formLogin(withDefaults()); 
		 http.csrf().disable();
		 http.headers().frameOptions().disable(); 
		 
		 return http.build();
	}

}
