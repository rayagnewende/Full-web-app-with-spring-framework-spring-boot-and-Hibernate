package com.learn.springTodoApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
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
	public String goToWelcome(@RequestParam String username, @RequestParam String password , ModelMap model )
	{
		if(loginAuthentificate.authenticate(username, password)) {
			model.addAttribute("username", username) ;
			model.addAttribute("password", password) ; 
			
			return "welcome"; 
		}
		return "login"; 
	}

}
