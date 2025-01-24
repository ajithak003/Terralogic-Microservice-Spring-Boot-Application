package com.touristmanagement.authenticationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touristmanagement.authenticationservice.authenticationDTO.AuthRequest;
import com.touristmanagement.authenticationservice.authenticationDTO.AuthResponse;
import com.touristmanagement.authenticationservice.services.AuthenticationService;
import com.touristmanagement.authenticationservice.utill.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private AuthenticationManager authenticationManager;
    
    private AuthenticationService authenticationService;
    
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
    	this.authenticationManager = authenticationManager;
    	this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
    	System.out.println("AuthenticationController login called");
    	 String token;
        try {
        	Authentication authenticate =  authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        	if(authenticate.isAuthenticated()) {
        	 token =  authenticationService.generateToken(authRequest.getUsername());
        	}else {
        		throw new RuntimeException("Invalic Credetials");
        	}
          
        	System.out.println("AuthenticationController login end");
        	
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("Invalid credentials"));
        }
    }
    
    @GetMapping("/validatetoken")
    boolean validateToken(@RequestHeader("token") String token) {
    	System.out.println("AuthenticationController validateToken called");

    	return authenticationService.validateToken(token);
    }
    
    


}
