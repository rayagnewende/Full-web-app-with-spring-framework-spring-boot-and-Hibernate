package com.learn.springTodoApp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {
	
	
	private TodoService todoService ;
	private TodoRepository todoRepository ; 


	
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}


	@RequestMapping("todo-list")
	public String allTodos(ModelMap model)
	{ 
		String username = getLoggedUsername(model); 
		List<Todo> todos = todoRepository.findByUsername(username); 
		
		model.addAttribute("todos", todos); 
		
		return "listTodos"; 
	}
	
	private String getLoggedUsername(ModelMap model) {
	Authentication authenticate = SecurityContextHolder.getContext().getAuthentication(); 
		
		return authenticate.getName();
	}
	
	
	@RequestMapping(value="add-todo", method =RequestMethod.GET )
	public String addTodo(ModelMap model )
	{ 
		String username = getLoggedUsername(model); 
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false); 
		 model.put("todo", todo); 
		return "addTodo"; 
	}



	
	
	@RequestMapping(value="add-todo", method =RequestMethod.POST)
	public String addTodo( ModelMap model, @Valid Todo todo, BindingResult result )
	{ 
		if(result.hasErrors())
		{
			return "addTodo"; 
		}
		String username = getLoggedUsername(model); 
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo-list"; 
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id )
	{ 
		todoRepository.deleteById(id);
		return "redirect:todo-list"; 
	}
	
	@RequestMapping(value="update-todo", method =RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model )
	{ 
		Todo todo = todoRepository.findById(id).get(); 
		model.addAttribute("todo", todo); 
		return "addTodo"; 
	}
	
	
	@RequestMapping(value="update-todo", method =RequestMethod.POST)
	public String updateAndSaveTodo( ModelMap model, @Valid Todo todo, BindingResult result )
	{ 
		if(result.hasErrors())
		{
			return "addTodo"; 
		}
		String username = getLoggedUsername(model); 
		todo.setUsername(username);
		todoRepository.save(todo); 
		return "redirect:todo-list"; 
	}
	    
	

}
