package com.paveloff.instaclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iuser")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String username;
	private String password;
	private String role;
	public int getId() {
		return id;
	}
	
	public User() {
		super();
	}

	public User(int id, String email, String username, String password, String role) {
		this(email, username, password, role);
		this.id = id;
	}

	public User(String email, String username, String password, String role) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return username + "(" + role + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User)) {
			return false;
		} else {
			User other = (User) obj;
			
			return username.equals(other.getUsername());
		}
	}
	
}
