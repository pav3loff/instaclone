package com.paveloff.instaclone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paveloff.instaclone.model.UserDTO;
import com.paveloff.instaclone.model.RegisterUserDTO;
import com.paveloff.instaclone.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Boolean> register(@RequestBody RegisterUserDTO userDTO) {
		if(userService.register(userDTO)) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<UserDTO> getByUsername(@PathVariable String username) {
		UserDTO userDto = userService.getUserDtoByUsername(username);
		
		return ResponseEntity.ok(userDto);
	}

}
