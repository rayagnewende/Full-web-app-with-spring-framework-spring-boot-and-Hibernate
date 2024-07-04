package com.learn.springTodoApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class WelcomeController {


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String login(ModelMap model)
	{
		model.put("username", this.getUserLoggedUsername()); 
		return "welcome"; 
	}
	
	private String getUserLoggedUsername() {
		Authentication authenticate = SecurityContextHolder.getContext().getAuthentication(); 
		
		return authenticate.getName();
	}
	


}
