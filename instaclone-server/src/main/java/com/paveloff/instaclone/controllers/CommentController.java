package com.paveloff.instaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paveloff.instaclone.model.Comment;
import com.paveloff.instaclone.model.CommentDTO;
import com.paveloff.instaclone.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping
	private ResponseEntity<Comment> add(@RequestBody CommentDTO commentDto) {
		Comment comment = commentService.add(commentDto);
		
		return ResponseEntity.ok(comment);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Comment> getById(@PathVariable Integer id) {
		Comment comment = commentService.getById(id);
		
		return ResponseEntity.ok(comment);
	}

}
