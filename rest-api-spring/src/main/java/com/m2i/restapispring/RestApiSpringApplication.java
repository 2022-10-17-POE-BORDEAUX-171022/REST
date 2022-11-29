package com.m2i.restapispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RestApiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiSpringApplication.class, args);
	}
}
