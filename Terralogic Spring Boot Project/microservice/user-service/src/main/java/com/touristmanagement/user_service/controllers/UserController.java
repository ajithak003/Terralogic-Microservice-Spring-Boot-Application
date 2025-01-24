package com.touristmanagement.user_service.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touristmanagement.user_service.models.User;
import com.touristmanagement.user_service.services.UserService;
import com.touristmanagement.user_service.userdto.UserRequest;
import com.touristmanagement.user_service.userdto.UserResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/saveorupdate")
	public ResponseEntity<String> saveorUpdate(@Valid @RequestBody UserRequest  user) {
		
	    String message = userService.saveorUpdate(user);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		
		List<UserResponse> response = userService.getAllUsers();
		return new ResponseEntity<List<UserResponse>>(response, HttpStatus.OK);
	}
	
	
}
