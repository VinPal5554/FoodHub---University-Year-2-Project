package com.example.foodbank_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.foodbank_app.exception.UserWasNotFoundException;
import com.example.foodbank_app.model.User;
import com.example.foodbank_app.service.UserService;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;

@Controller
public class ForgotPasswordController {
 
	@Autowired
	private UserService userServices;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm(Model model) {
		model.addAttribute("pageTitle", "Forgot Password");
		return "/forgot_password_form";	
	}
	@PostMapping("/forgot_password")
	public String processForgotPasswordForm(HttpServletRequest request, Model model) throws UnsupportedEncodingException, MessagingException {
		String email = request.getParameter("email");
		String token = RandomString.make(30);
		
		System.out.println("For this email address" + email);
		System.out.println("This is your reset password token" + token);
		
		try {
		userServices.updateResetPasswordToken(token, email);
		
		String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
		System.out.println(resetPasswordLink);
		
		sendEmail(email,resetPasswordLink);
		
		model.addAttribute("message","An email has been sent to you");
		
		} catch(UserWasNotFoundException ex) {
			model.addAttribute("error",ex.getMessage());
		}  catch(UnsupportedEncodingException | MessagingException e) {
		    model.addAttribute("error","Error sending email");
		}
		model.addAttribute("pageTitle", "Forgot Password");
		return"/forgot_password_form";
		
	}
	private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
	    helper.setFrom("Foodhub@gmail.com", "FoodHub");
	    helper.setTo(email);
	    
	    String subject ="This is the password reset link";
	    String content = "<p>The following link will be used to reset your password</p>"
	    		+ "<a href=\"" + resetPasswordLink + "\">Reset Password</a>";
	    
	    helper.setSubject(subject);
	    helper.setText(content,true);
	    
	    mailSender.send(message);
	} 
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token")String token,Model model) {
		User user = userServices.get(token);
		if (user==null) {
			model.addAttribute("title","Reset your password");
			model.addAttribute("message","Invalid Token");
			return "message";
		}
		model.addAttribute("token",token);
		model.addAttribute("pageTitle","Reset Your Password");
		
		return "reset_password_form";
	}
	@GetMapping("/reset_password_Message")
	public String processResetPassword(HttpServletRequest request,Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		
		User user = userServices.get(token);
		if (user==null) {
			model.addAttribute("title","Reset your password");
			model.addAttribute("message","Invalid Token");
			
		}
		else {
			userServices.updatePassword(user, password);
			model.addAttribute("message","Password has been changed ");
		}
		return "/login";
	}
	
}

	
