package com.m2i.restapispring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.restapispring.modele.User;

@RestController
@RequestMapping("/user")
public class UserController {

	
	List<User> users = new ArrayList<>();
	
	@GetMapping
	public List<User> getAllUsers(){
		return users;
	}
	
	@GetMapping(value =" /{id}")
	public User getById(@PathVariable("id") int id){
		
		for (User u : users) {
			if ( u.getId() == id)
				return u;
				
		}	
		return null;
	}
	
	
	@PostMapping
	public void addUser(@RequestBody User u) {
		users.add(u);
	}

	@PutMapping(value ="/{id}")
	public void updateUserById(@PathVariable int id, @RequestBody User u) {
		
		for ( User user : users) {
			if (user.getId() == id) {
				user.setEmail( u.getEmail() );
				user.setPassword( u.getPassword() );
				user.setName( u.getName());
			}
		}
	}
	
	

	@DeleteMapping(value ="/{id}")
	public void deleteUserById( @PathVariable int id  ) {
		users.removeIf( (u) -> u.getId() == id );
	}
}
