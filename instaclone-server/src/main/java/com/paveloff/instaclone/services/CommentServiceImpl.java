package com.paveloff.instaclone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paveloff.instaclone.model.Comment;
import com.paveloff.instaclone.model.CommentDTO;
import com.paveloff.instaclone.model.Post;
import com.paveloff.instaclone.model.User;
import com.paveloff.instaclone.repositories.CommentRepository;
import com.paveloff.instaclone.repositories.PostRepository;
import com.paveloff.instaclone.repositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Comment add(CommentDTO commentDto) {
		Post post = postRepository.getOne(commentDto.getPostId());
		User owner = userRepository.findByUsername(commentDto.getOwnerUsername()).get();
		
		Comment comment = new Comment(commentDto.getText(), post, owner);
		commentRepository.save(comment);
		
		List<Comment> comments = post.getComments();
		comments.add(comment);
		post.setComments(comments);
		postRepository.saveAndFlush(post);
		
		return comment;
	}

	@Override
	public Comment getById(Integer id) {
		Optional<Comment> optionalComment = commentRepository.findById(id);
		
		if(optionalComment.isPresent()) {
			return optionalComment.get();
		} else {
			return null;
		}
	}

}
