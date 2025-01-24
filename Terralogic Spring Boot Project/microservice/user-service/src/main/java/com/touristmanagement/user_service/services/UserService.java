package com.touristmanagement.user_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.touristmanagement.user_service.models.User;
import com.touristmanagement.user_service.repository.UserDAO;
import com.touristmanagement.user_service.userdto.UserRequest;
import com.touristmanagement.user_service.userdto.UserResponse;


@Service
public class UserService {

	UserDAO userDAO;
	
	@Autowired
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public String saveorUpdate(UserRequest userRequest) {
		
		User newUser = mpaToUser(userRequest);
		
		User existingUser = userDAO.findbyUsername(newUser.getUsername());
		try {
		if(existingUser != null) {
			if(newUser.getUsername() != null) existingUser.setUsername(newUser.getUsername());
			if(newUser.getFirstname() != null) existingUser.setFirstname(newUser.getFirstname());
			if(newUser.getLastname() != null) existingUser.setLastname(newUser.getLastname());
			if(newUser.getPassword() != null) existingUser.setPassword(encoder.encode(newUser.getPassword()));
			if(newUser.getEmail() != null) existingUser.setEmail(newUser.getEmail());
			if(newUser.getContact() != null) existingUser.setContact(newUser.getContact());
			if(newUser.getTimeout() != null) existingUser.setTimeout(newUser.getTimeout());
			if(newUser.getPrimaryGroupName() != null) existingUser.setPrimaryGroupName(newUser.getPrimaryGroupName());
			if(newUser.getTimeout() != null) existingUser.setTimeout(newUser.getTimeout());

             userDAO.save(existingUser);
             return "User Updated Successfully";
		}else {
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		userDAO.save(newUser);		
		return "User Create Successfully";

		}
		}catch(Exception e){
			e.printStackTrace();
	        return "An error occurred while saving or updating the user: " + e.getMessage();

		}
		
		
	}

	private User mpaToUser(UserRequest newUser) {
		User user = new User();
		
		user.setUsername(newUser.getUsername());
		user.setFirstname(newUser.getFirstname());
		user.setMiddlename(newUser.getMiddlename());
		user.setLastname(newUser.getLastname());
		user.setPassword(newUser.getPassword());
		user.setEmail(newUser.getEmail());
		user.setContact(newUser.getContact());
		user.setExpirationDate(newUser.getExpirationDate());
		user.setDescription(newUser.getDescription());
		user.setTimeout(newUser.getTimeout());
		user.setDatetimeFormat(newUser.getDatetimeFormat());
		user.setRoles(newUser.getRoles());
		user.setScopes(newUser.getScopes());
		user.setPrimaryGroupName(newUser.getPrimaryGroupName());
		user.setSecondaryGroupName(newUser.getSecondaryGroupName());
		user.setLanguage(newUser.getLanguage());
		user.setOrganization(newUser.getOrganization());
		user.setTimeZone(newUser.getTimeZone());
		user.setMemo(newUser.getMemo());
		
		return user;
	}

	public List<UserResponse> getAllUsers() {
		
		List<User> users = userDAO.findAll();
		
		List<UserResponse> userResponse = users.stream().map(user -> mapToUserResponse(user)).toList();
		
		return userResponse;
	} 
	
	public UserResponse mapToUserResponse(User user) {
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setUserId(user.getId());
		userResponse.setUsername(user.getUsername());
		userResponse.setFirstname(user.getFirstname());
		userResponse.setMiddlename(user.getMiddlename());
		userResponse.setLastname(user.getLastname());
		userResponse.setPassword("********");
		userResponse.setEmail(user.getEmail());
		userResponse.setContact(user.getContact());
		userResponse.setExpirationDate(user.getExpirationDate());
		userResponse.setDescription(user.getDescription());
		userResponse.setTimeout(user.getTimeout());
		userResponse.setDatetimeFormat(user.getDatetimeFormat());
		userResponse.setRoles(user.getRoles());
		userResponse.setScopes(user.getScopes());
		userResponse.setPrimaryGroupName(user.getPrimaryGroupName());
		userResponse.setSecondaryGroupName(user.getSecondaryGroupName());
		userResponse.setLanguage(user.getLanguage());
		userResponse.setOrganization(user.getOrganization());
		userResponse.setTimeZone(user.getTimeZone());
		userResponse.setMemo(user.getMemo());
		
		return userResponse;
	}

}
