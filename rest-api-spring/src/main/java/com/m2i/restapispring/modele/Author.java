package com.m2i.restapispring.modele;

public class Author {
	
	private String name;
	private int age;
	private String description;
	private int nbArticles;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNbArticles() {
		return nbArticles;
	}
	public void setNbArticles(int nbArticles) {
		this.nbArticles = nbArticles;
	}
	public Author(String name, int age, String description, int nbArticles) {
		super();
		this.name = name;
		this.age = age;
		this.description = description;
		this.nbArticles = nbArticles;
	}

	public String toString() {
		return "Author [name=" + name + ", age=" + age + ", description=" + description + ", nbArticles=" + nbArticles
				+ "]";
	}
	
	
}
