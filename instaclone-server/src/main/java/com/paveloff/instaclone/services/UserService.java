package com.paveloff.instaclone.services;

import com.paveloff.instaclone.model.RegisterUserDTO;
import com.paveloff.instaclone.model.UserDTO;

public interface UserService {
	
	boolean register(RegisterUserDTO userDTO);

	UserDTO getUserDtoByUsername(String username);

}
