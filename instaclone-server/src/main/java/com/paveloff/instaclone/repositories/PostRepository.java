package com.paveloff.instaclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paveloff.instaclone.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
