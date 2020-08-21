package com.paveloff.instaclone.model;

import java.util.List;

public class UserDTO {
	
	private String username;
	private List<Post> posts;
	private String displayName;
	private String description;
	private int numOfPosts;
	private int numOfFollowers;
	private int numOfFollowing;
	private Media profilePicture;
	
	public UserDTO(String username, List<Post> posts, String displayName, String description, int numOfPosts,
			int numOfFollowers, int numOfFollowing, Media profilePicture) {
		super();
		this.username = username;
		this.posts = posts;
		this.displayName = displayName;
		this.description = description;
		this.numOfPosts = numOfPosts;
		this.numOfFollowers = numOfFollowers;
		this.numOfFollowing = numOfFollowing;
		this.profilePicture = profilePicture;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumOfPosts() {
		return numOfPosts;
	}

	public void setNumOfPosts(int numOfPosts) {
		this.numOfPosts = numOfPosts;
	}

	public int getNumOfFollowers() {
		return numOfFollowers;
	}

	public void setNumOfFollowers(int numOfFollowers) {
		this.numOfFollowers = numOfFollowers;
	}

	public int getNumOfFollowing() {
		return numOfFollowing;
	}

	public void setNumOfFollowing(int numOfFollowing) {
		this.numOfFollowing = numOfFollowing;
	}

	public Media getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Media profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}

