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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.restapispring.entity.Author;


@RestController
@RequestMapping("/hello")
public class HelloController {

	//List<User> users = new ArrayList<>();
	
	@GetMapping
	public String hello() {
		return "Hello World !";
	}
	
	@GetMapping(value="/java")
	public String newPath() {
		return "Hello Java";
	}
	
	@PostMapping // localhost:8080/hello?name=java
	public String viaParam(@RequestParam("name") String name  ) {			
		return "Hello " + name;
	}
	

	@PutMapping(value = "/{name}") // localhost:8080/hello/java
	public String viaPathVariable( @PathVariable("name") String name ) {
		return "Hello " + name;
	}
	
	@DeleteMapping // localhost:8080/hello
	public String viaRequestBody( @RequestBody String name ) {
		return "Hello " + name;		
	}
	
	@GetMapping(value="/author")
	public Author getAuthor() {
		return new Author(0, null, null, null, 0);
	}
	
	@PostMapping(value="/author")
	public void sendAuthor( @RequestBody Author a ) {
		System.out.println(a.toString());
	}
	
	
}




