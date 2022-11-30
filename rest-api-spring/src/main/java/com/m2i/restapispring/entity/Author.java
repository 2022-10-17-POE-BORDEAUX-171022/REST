package com.m2i.restapispring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String nbPubli;
	private int roomId;
	
	
	public Author(int id, String firstName, String lastName, String nbPubli, int roomId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nbPubli = nbPubli;
		this.roomId = roomId;
	}
	public Author(String firstName, String lastName, String nbPubli, int roomId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nbPubli = nbPubli;
		this.roomId = roomId;
	}
	public Author() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNbPubli() {
		return nbPubli;
	}
	public void setNbPubli(String nbPubli) {
		this.nbPubli = nbPubli;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	
	
	
}
