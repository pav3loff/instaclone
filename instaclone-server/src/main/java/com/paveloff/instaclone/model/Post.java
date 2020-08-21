package com.paveloff.instaclone.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ipost")
public class Post {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String caption;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	@OneToOne
	private Media media;
	
	@OneToOne
	@JsonIgnore
	private User owner;

	public Post() {
		super();
	}

	public Post(int id, String caption, List<Comment> comments, Media media, User owner) {
		this(caption, comments, media, owner);
		this.id = id;
	}

	public Post(String caption, List<Comment> comments, Media media, User owner) {
		this.caption = caption;
		this.comments = comments;
		this.media = media;
		this.owner = owner;
	}
	
	public Post(String caption, Media media, User owner) {
		this.caption = caption;
		this.comments = new ArrayList<>();
		this.media = media;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
