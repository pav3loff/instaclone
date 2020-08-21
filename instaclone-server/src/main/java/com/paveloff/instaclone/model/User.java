package com.paveloff.instaclone.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name = "display_name")
	private String displayName;
	
	private String description;
	
	@OneToMany(mappedBy = "owner")
	private List<Post> posts;
	
	@Column(name = "num_of_posts")
	private int numOfPosts;
	
	@Column(name = "num_of_followers")
	private int numOfFollowers;
	
	@Column(name = "num_of_following")
	private int numOfFollowing;
	
	@OneToOne
	private Media profilePicture;
	
	public int getId() {
		return id;
	}
	
	public User() {
		super();
	}

	public User(int id, String email, String username, String password, String role, 
			String displayName, String description, List<Post> posts, int numOfPosts, 
			int numOfFollowers, int numOfFollowing, Media profilePicture) {
		this(email, username, password, role, displayName, description, posts, numOfPosts, 
				numOfFollowers, numOfFollowing, profilePicture);
		this.id = id;
	}

	public User(String email, String username, String password, String role, String displayName,
			String description, List<Post> posts, int numOfPosts, int numOfFollowers, 
			int numOfFollowing, Media profilePicture) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.displayName = displayName;
		this.description = description;
		this.posts = posts;
		this.numOfPosts = numOfPosts;
		this.numOfFollowers = numOfFollowers;
		this.numOfFollowing = numOfFollowing;
		this.profilePicture = profilePicture;
	}
	
	public User(String email, String username, String password, String role, String displayName, 
			String description, Media profilePicture) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.description = description;
		this.role = role;
		this.posts = new ArrayList<>();
		this.numOfPosts = this.numOfFollowers = this.numOfFollowing = 0;
		this.profilePicture = profilePicture;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
