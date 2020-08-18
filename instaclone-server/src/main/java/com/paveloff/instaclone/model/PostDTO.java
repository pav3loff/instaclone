package com.paveloff.instaclone.model;

public class PostDTO {
	
	private String caption;
	private String mediaUrl;
	private String ownerUsername;
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getMediaUrl() {
		return mediaUrl;
	}
	
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
	public String getOwnerUsername() {
		return ownerUsername;
	}
	
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

}
