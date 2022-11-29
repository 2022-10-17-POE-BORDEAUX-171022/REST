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

import com.m2i.restapispring.entity.Product;
import com.m2i.restapispring.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	@GetMapping
	public List<Product> getAllProduct() {
		return repo.findAll();
	}
	
	@PostMapping
	public void addProduct(@RequestBody Product p) {
		repo.save(p);
	}
	
	@DeleteMapping(value = "/{id}" )
	public void deleteProduct( @PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateProduct(@RequestBody Product p, @PathVariable int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			p.setId(id);
			repo.save(p);
		}
	}
	
}
