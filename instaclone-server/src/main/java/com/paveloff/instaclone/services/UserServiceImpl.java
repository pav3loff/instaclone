package com.paveloff.instaclone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.paveloff.instaclone.model.User;
import com.paveloff.instaclone.model.UserDTO;
import com.paveloff.instaclone.model.Media;
import com.paveloff.instaclone.model.RegisterUserDTO;
import com.paveloff.instaclone.repositories.MediaRepository;
import com.paveloff.instaclone.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MediaRepository mediaRepository;

	@Override
	public boolean register(RegisterUserDTO userDTO) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Media media = new Media(userDTO.getProfilePictureUrl());
		mediaRepository.save(media);
		
		User user = new User(userDTO.getEmail(), userDTO.getUsername(), encoder.encode(userDTO.getPassword()), 
				"ROLE_USER", userDTO.getDisplayName(), userDTO.getDescription(), media);
		
		try {
			userRepository.save(user);
			
			return true;
		} catch (Exception exc) {
			return false;
		}
	}

	@Override
	public UserDTO getUserDtoByUsername(String username) {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			
			return new UserDTO(user.getUsername(), user.getPosts(), user.getDisplayName(),
					user.getDescription(), user.getNumOfPosts(), user.getNumOfFollowers(),
					user.getNumOfFollowing(), user.getProfilePicture());
		} else {
			return null;
		}
	}

}
