package com.mthree.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDTO {
	
	private int id;
	
	String username;
	
	// constructor
	public UserDTO() {}
	
	public UserDTO(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	//setter and getter
	
	public synchronized int getId() {
		return id;
	}

	public synchronized void setId(int id) {
		this.id = id;
	}

	public synchronized String getUsername() {
		return username;
	}

	public synchronized void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + "]";
	}
	
	
	
	
	
}
