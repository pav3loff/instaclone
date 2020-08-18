package com.paveloff.instaclone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paveloff.instaclone.model.Media;
import com.paveloff.instaclone.model.Post;
import com.paveloff.instaclone.model.PostDTO;
import com.paveloff.instaclone.model.User;
import com.paveloff.instaclone.repositories.MediaRepository;
import com.paveloff.instaclone.repositories.PostRepository;
import com.paveloff.instaclone.repositories.UserRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	MediaRepository mediaRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Post create(PostDTO postDto) {
		Optional<User> optionalOwner = userRepository.findByUsername(postDto.getOwnerUsername());
		
		if(optionalOwner.isPresent()) {
			User owner = optionalOwner.get();
			Media media = new Media(postDto.getMediaUrl());
			mediaRepository.save(media);
			
			Post post = new Post(postDto.getCaption(), media, owner);
			
			return postRepository.save(post);
		} else {
			return null;
		}
	}

	@Override
	public Post getById(Integer id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		
		if(optionalPost.isPresent()) {
			return optionalPost.get();
		} else {
			return null;
		}
	}

}
