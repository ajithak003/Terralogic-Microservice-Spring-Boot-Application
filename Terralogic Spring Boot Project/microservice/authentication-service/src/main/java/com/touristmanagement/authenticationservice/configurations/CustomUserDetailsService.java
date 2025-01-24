package com.touristmanagement.authenticationservice.configurations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.touristmanagement.authenticationservice.models.Users;
import com.touristmanagement.authenticationservice.repository.AuthenticationDAO;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationDAO authDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> credential = authDAO.findByUsername(username);
        return credential.map(CustomUserDetails::new).orElseThrow(() ->
        		new UsernameNotFoundException("user not found with name :" + username));
    }
}