package com.paveloff.instaclone.services;

import com.paveloff.instaclone.model.Post;
import com.paveloff.instaclone.model.PostDTO;

public interface PostService {
	
	Post create(PostDTO postDto);
	
	Post getById(Integer id);

}
