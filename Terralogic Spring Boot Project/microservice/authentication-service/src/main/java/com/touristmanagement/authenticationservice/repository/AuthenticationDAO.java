package com.touristmanagement.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.touristmanagement.authenticationservice.models.Users;

@Repository
public interface AuthenticationDAO extends JpaRepository<Users, Long>{
	
	@Query(value = "SELECT * FROM user_details_terralogic user_0 where user_0.username = :username",nativeQuery = true)
	Optional<Users> findByUsername(String username);

}
