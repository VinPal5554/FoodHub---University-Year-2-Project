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
@RequestMapping("/businessregistration")
public class BusinessRegistrationController {

	private UserService userService;
	
	public BusinessRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public BusinessRegistrationDto businessRegistrationDto() {
		return new BusinessRegistrationDto();
	}
	
	@GetMapping
	public String showBusinessRegistrationForm() {
		return "businessregistration";
	}
	
	@PostMapping
	public String registerBusinessAccount(@ModelAttribute("user") BusinessRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/businessregistration?success";
	}
}
