package com.paveloff.instaclone.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paveloff.instaclone.model.User;
import com.paveloff.instaclone.model.UserDetailsImpl;
import com.paveloff.instaclone.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			
			return new UserDetailsImpl(user.getUsername(), user.getPassword(), user.getRole());
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found");
		}
	}

}
