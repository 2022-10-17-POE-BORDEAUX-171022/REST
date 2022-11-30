package com.m2i.restapispring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.restapispring.entity.Author;
import com.m2i.restapispring.repository.AuthorRepository;



@Service
public class AuthorService {

	
	@Autowired
	AuthorRepository repo;
	
	
	
	public List<Author> getAuthor(){		
		return repo.findAll();
	}
	
	
	
	public Author postAuthor(Author a) {
		return repo.save(a);
	}
	
	
	public Author putAuthor(Author a) {
		Author newAuthor = repo.findById(a.getId()).orElse(null);
		if (newAuthor != null) {
			newAuthor.setFirstName( a.getFirstName());
			newAuthor.setLastName( a.getLastName());
			newAuthor.setRoomId( a.getRoomId());
			newAuthor.setNbPubli( a.getNbPubli());
			repo.save(newAuthor);
						
		}

		return newAuthor;
	}
	
	public String deleteAuthor(int id) {
		if ( repo.findById(id).isPresent() ) {
			
			repo.deleteById(id);
			return "Author deleted :" + id;
		}
		return "Author not found :" + id;
	}
	
	public List<String> getAuthorInRoom(int id){
		return this.repo.getListAuthor(id);
	}
	
}
