package com.paveloff.instaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paveloff.instaclone.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);

}
