package com.paveloff.instaclone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paveloff.instaclone.model.User;
import com.paveloff.instaclone.model.UserDTO;
import com.paveloff.instaclone.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean register(UserDTO userDTO) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		User user = new User(userDTO.getEmail(), userDTO.getUsername(), encoder.encode(userDTO.getPassword()), "ROLE_USER");
		
		try {
			userRepository.save(user);
			
			return true;
		} catch (Exception exc) {
			return false;
		}
	}

}
