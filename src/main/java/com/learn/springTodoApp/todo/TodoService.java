package com.learn.springTodoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>(); 
	private static int count= 0; 
	
	static {
		todos.add( new Todo(++count,"learn", "it is an aws course", LocalDate.now().plusYears(1), false)); 
		todos.add( new Todo(++count,"learn", "it is an english course", LocalDate.now().plusYears(2), false)); 
		todos.add( new Todo(++count,"learn", "it is an francais course", LocalDate.now().plusYears(3), false)); 
	}
	
	public List<Todo> findByUsername(String username){
		return todos ; 
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done)
	{
	       todos.add(new Todo(++count, username, description, targetDate,false));  
	}
}
