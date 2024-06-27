package com.learn.springTodoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>(); 
	
	static {
		todos.add( new Todo(1,"learn", "it is an aws course", LocalDate.now().plusYears(1), false)); 
		todos.add( new Todo(2,"learn", "it is an english course", LocalDate.now().plusYears(2), false)); 
		todos.add( new Todo(3,"learn", "it is an francais course", LocalDate.now().plusYears(3), false)); 

	}
	
	public List<Todo> findByUsername(String username){
		return todos ; 
	}

}
