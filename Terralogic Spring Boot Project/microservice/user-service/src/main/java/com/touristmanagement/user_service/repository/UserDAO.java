package com.touristmanagement.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.touristmanagement.user_service.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{

	@Query(value = "SELECT * FROM user_details_terralogic user_0 where user_0.username = :username",nativeQuery = true)
	public User findbyUsername(String username);

}
