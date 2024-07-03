package com.learn.springTodoApp.login;

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
		model.put("username", "kabore"); 
		return "welcome"; 
	}
	


}