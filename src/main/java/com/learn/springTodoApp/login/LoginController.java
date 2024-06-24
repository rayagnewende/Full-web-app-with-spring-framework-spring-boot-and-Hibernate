package com.learn.springTodoApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	
	private LoginService loginAuthentificate ; 
	
	public LoginController(  LoginService loginAuthentificate) {
		super();
		this.loginAuthentificate = loginAuthentificate; 
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login()
	{
		return "login"; 
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcome(@RequestParam String name, @RequestParam String password , ModelMap model )
	{
		if(loginAuthentificate.authenticate(name, password)) {
			model.put("name", name); 
			model.put("password", password); 
			
			return "welcome"; 
		}
		return "login"; 
	}

}
