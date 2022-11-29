package com.m2i.restapispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.restapispring.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
