package com.example.foodbank_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodbank_app.service.UserService;
import com.example.foodbank_app.web.dto.BusinessRegistrationDto;
import com.example.foodbank_app.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/newuser")
public class NewUserRegistration {

	private UserService userService;
	
	public NewUserRegistration(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "new_user";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/adminhomepage";
	}
}