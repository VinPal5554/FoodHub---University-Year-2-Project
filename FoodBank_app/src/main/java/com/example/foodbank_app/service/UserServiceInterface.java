package com.example.foodbank_app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.foodbank_app.model.User;
import com.example.foodbank_app.web.dto.UserRegistrationDto;

public interface UserServiceInterface extends UserDetailsService{

	User findByUsername(String username);
	User save(UserRegistrationDto registration);
}
