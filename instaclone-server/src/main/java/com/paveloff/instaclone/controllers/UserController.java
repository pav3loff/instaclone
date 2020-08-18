package com.paveloff.instaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paveloff.instaclone.model.UserDTO;
import com.paveloff.instaclone.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody UserDTO userDTO) {
		if(userService.register(userDTO)) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

}
