package com.paveloff.instaclone.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paveloff.instaclone.model.UsernameDTO;
import com.paveloff.instaclone.services.AuthenticationRequest;
import com.paveloff.instaclone.services.AuthenticationResponse;
import com.paveloff.instaclone.services.UserDetailsServiceImpl;
import com.paveloff.instaclone.utilities.JWTUtil;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@GetMapping("/")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(), 
							authenticationRequest.getPassword()));
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			
			String jwt = jwtUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));
		} catch(BadCredentialsException exc) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/validate_token")
	public ResponseEntity<Boolean> isTokenValid(@RequestBody AuthenticationResponse authenticationResponse) {
		if(jwtUtil.extractExpiration(authenticationResponse.getJwt()).after(new Date())) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/extract_username_from_jwt")
	public ResponseEntity<UsernameDTO> extractUsernameFromJwt(@RequestBody AuthenticationResponse authenticationResponse) {
		String username = jwtUtil.extractUsername(authenticationResponse.getJwt());
		
		return ResponseEntity.ok(new UsernameDTO(username));
	}

}
