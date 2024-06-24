package com.learn.springTodoApp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public Boolean authenticate(String username, String password){
		
		
		Boolean isValideUsername = username.equalsIgnoreCase("kabore"); 
		Boolean isValidePassword = password.equalsIgnoreCase("123456"); 
		
		
		return isValideUsername && isValidePassword ; 
	}

}
