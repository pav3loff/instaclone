package com.paveloff.instaclone.model;

public class CommentDTO {
	
	private String text;
	private int postId;
	private String ownerUsername;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getOwnerUsername() {
		return ownerUsername;
	}
	
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

}
