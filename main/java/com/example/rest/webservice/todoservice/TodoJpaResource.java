package com.example.rest.webservice.todoservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaResource {

	@Autowired
	private TodoJPARepository todoJpaRepository;
	
	@GetMapping(value="/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoJpaRepository.findByUserName(username);
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username ,@PathVariable long id){
		//Todo todo = todoJpaRepository.deleteById(id);
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@GetMapping(value="/jpa/users/{username}/todos/{id}")
	public Todo getTodos(@PathVariable String username, @PathVariable long id){
		
		return todoJpaRepository.findById(id).get();
	}
	
	@PutMapping(value="/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, 
			@PathVariable long id, 
			@RequestBody Todo todo) {
		Todo todoUpdate = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdate, HttpStatus.OK);
	}
	
	@PostMapping(value="/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		System.out.println(username);
		todo.setUserName(username);
		Todo createdTodo = todoJpaRepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
