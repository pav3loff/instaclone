package com.paveloff.instaclone.services;

import com.paveloff.instaclone.model.Comment;
import com.paveloff.instaclone.model.CommentDTO;

public interface CommentService {
	
	Comment add(CommentDTO commentDto);
	
	Comment getById(Integer id);

}
