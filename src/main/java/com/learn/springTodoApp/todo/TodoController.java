package com.learn.springTodoApp.todo;

import java.time.LocalDate;
import java.util.List;

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
public class TodoController {
	
	private TodoService todoService ;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	} 
	
	
	@RequestMapping("todo-list")
	public String allTodos(ModelMap model)
	{ 
		List<Todo> todos = todoService.findByUsername("learn"); 
		
		model.addAttribute("todos", todos); 
		
		return "listTodos"; 
	}
	
	
	@RequestMapping(value="add-todo", method =RequestMethod.GET )
	public String addTodo(ModelMap model )
	{ 
		String username = (String) model.get("username"); 
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
		String username = (String) model.get("username"); 
		todoService.addTodo(username, todo.getDescription(),todo.getTargetDate(), false);
		return "redirect:todo-list"; 
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id )
	{ 
		todoService.deleteTodo(id);
		return "redirect:todo-list"; 
	}
	
	@RequestMapping(value="update-todo", method =RequestMethod.GET)
	public String updateTodo(@RequestParam int id, ModelMap model )
	{ 
		Todo todo = todoService.findById(id);
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
		String username = (String) model.get("username"); 
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:todo-list"; 
	}
	
	
	

}
