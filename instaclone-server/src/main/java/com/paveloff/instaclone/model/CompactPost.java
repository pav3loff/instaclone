package com.paveloff.instaclone.model;

public class CompactPost {
	
	private int id;
	private Media media;
	
	public CompactPost(int id, Media media) {
		super();
		this.id = id;
		this.media = media;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

}
