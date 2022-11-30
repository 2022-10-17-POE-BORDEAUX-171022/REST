package com.m2i.restapispring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.m2i.restapispring.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	
	@Query("SELECT a.firstName FROM Author a WHERE a.roomId = :id")
	public List<String> getListAuthor(@Param("id") int id );
}

