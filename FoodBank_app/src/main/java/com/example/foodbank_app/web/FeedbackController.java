package com.example.foodbank_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.foodbank_app.service.UserService;
import com.example.foodbank_app.web.dto.FeedbackDto;

	@Controller
	@RequestMapping("/feedback")
	
	public class FeedbackController {

		private UserService userService;
		
		public FeedbackController(UserService userService) {
			super();
			this.userService = userService;
		}
		
		@ModelAttribute("feedback")
		public FeedbackDto FeedbackDto() {
			return new FeedbackDto();
		}
		
		@GetMapping
		public String showRegistrationForm() {
			return "feedback";
		}
		
		@PostMapping
		public String registerUserAccount(@ModelAttribute("feedback") FeedbackDto feedbackDto) {
			userService.save(feedbackDto);
			//userService.sendfeedbackEmail("foodbank012@gmail.com");
			return "redirect:/";
		}
	}
	

