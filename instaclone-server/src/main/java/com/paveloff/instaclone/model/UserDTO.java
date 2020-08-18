package com.paveloff.instaclone.model;

import java.util.List;

public class UserDTO {
	
	private String username;
	private List<Post> posts;
	
	public UserDTO(String username, List<Post> posts) {
		this.username = username;
		this.posts = posts;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
}

