package com.m2i.restapispring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.restapispring.entity.Author;
import com.m2i.restapispring.service.AuthorService;


@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@GetMapping()
	public List<Author> getAuthor(){
		return service.getAuthor();
	}
	
	@PostMapping()
	public Author postAuthor(@RequestBody Author m) {
		return service.postAuthor(m);
	}
	
	@PutMapping()
	public Author putMessage(@RequestBody Author m) {
		return service.putAuthor(m);
	}
	
	@DeleteMapping("/{id}")
	public String delMessage(@PathVariable int id) {
		return service.deleteAuthor(id);
	}
	
	@GetMapping("/list/{id}")
	public List<String> getList(@PathVariable int id){
		return this.service.getAuthorInRoom(id);
	}
	
	
}
