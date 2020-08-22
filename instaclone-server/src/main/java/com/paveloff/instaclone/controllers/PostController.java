package com.paveloff.instaclone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paveloff.instaclone.model.CompactPost;
import com.paveloff.instaclone.model.Post;
import com.paveloff.instaclone.model.PostDTO;
import com.paveloff.instaclone.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping
	private ResponseEntity<Post> create(@RequestBody PostDTO postDto) {
		Post post = postService.create(postDto);
		
		return ResponseEntity.ok(post);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Post> get(@PathVariable Integer id) {
		Post post = postService.getById(id);
		
		return ResponseEntity.ok(post);
	}
	
	@GetMapping("/{username}/compact")
	private ResponseEntity<List<CompactPost>> getCompactPostsByUsername(@PathVariable String username) {
		List<CompactPost> compactPosts = postService.getCompactPostsByUsername(username);
		
		return ResponseEntity.ok(compactPosts);
	}

}
