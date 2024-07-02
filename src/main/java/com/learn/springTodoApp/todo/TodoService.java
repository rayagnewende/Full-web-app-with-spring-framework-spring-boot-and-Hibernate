package com.learn.springTodoApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

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
	
	public void deleteTodo(int id)
	{ 
		todos.removeIf(todo ->  todo.getId() == id); 
	}
	public Todo findById(int id)
	{
		Predicate<? super Todo > predicate = todo -> todo.getId() == id ; 
		
		return todos.stream().filter(predicate).findFirst().get(); 
	}
	
	public void updateTodo(@Valid Todo todo)
	{
		deleteTodo(todo.getId());
		todos.add(todo); 
	}
}
