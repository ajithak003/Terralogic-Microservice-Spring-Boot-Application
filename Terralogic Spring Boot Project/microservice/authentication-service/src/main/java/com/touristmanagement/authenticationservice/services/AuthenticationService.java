package com.touristmanagement.authenticationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touristmanagement.authenticationservice.utill.JwtTokenUtil;

@Service
public class AuthenticationService {

	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	public AuthenticationService(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	public String generateToken(String username) {
		return jwtTokenUtil.generateToken(username);
	}

	public boolean validateToken(String token) {
    	System.out.println("AuthenticationService validateToken called");
		return jwtTokenUtil.validateToken(token);
	}

}
