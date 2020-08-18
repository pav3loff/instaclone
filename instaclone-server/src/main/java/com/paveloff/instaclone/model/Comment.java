package com.paveloff.instaclone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "icomment")
public class Comment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String text;
	
	@OneToOne
	@JoinColumn(name = "post_id")
	@JsonIgnore
	private Post post;
	
	@OneToOne
	@JoinColumn(name = "owner_id")
	@JsonIgnore
	private User owner;

	public Comment() {
		super();
	}
	
	public Comment(int id, String text, Post post, User owner) {
		this(text, post, owner);
		this.id = id;
	}

	public Comment(String text, Post post, User owner) {
		this.text = text;
		this.post = post;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
