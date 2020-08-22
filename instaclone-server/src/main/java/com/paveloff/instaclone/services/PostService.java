package com.paveloff.instaclone.services;

import java.util.List;

import com.paveloff.instaclone.model.CompactPost;
import com.paveloff.instaclone.model.Post;
import com.paveloff.instaclone.model.PostDTO;

public interface PostService {
	
	Post create(PostDTO postDto);
	
	Post getById(Integer id);
	
	List<CompactPost> getCompactPostsByUsername(String username);

}
