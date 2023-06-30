package com.example.foodbank_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodbank_app.service.UserService;
import com.example.foodbank_app.web.dto.AdminRegistrationDto;
import com.example.foodbank_app.web.dto.BusinessRegistrationDto;
import com.example.foodbank_app.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/adminregistration")
public class AdminRegistrationController {

	private UserService userService;
	
	public AdminRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public AdminRegistrationDto adminRegistrationDto() {
		return new AdminRegistrationDto();
	}
	
	@GetMapping
	public String showAdminRegistrationForm() {
		return "adminregistration";
	}
	
	@PostMapping
	public String registerAdminAccount(@ModelAttribute("user") AdminRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/adminregistration?success";
	}
}
