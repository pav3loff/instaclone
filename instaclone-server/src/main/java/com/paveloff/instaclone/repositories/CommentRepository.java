package com.paveloff.instaclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paveloff.instaclone.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
