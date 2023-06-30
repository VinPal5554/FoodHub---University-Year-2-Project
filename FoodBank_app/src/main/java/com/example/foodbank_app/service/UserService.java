package com.example.foodbank_app.service;


import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.foodbank_app.exception.ResourceNotFoundException;
import com.example.foodbank_app.exception.UserWasNotFoundException;
import com.example.foodbank_app.model.Feedback;
import com.example.foodbank_app.model.Role;
import com.example.foodbank_app.model.User;
import com.example.foodbank_app.repository.UserRepository;
import com.example.foodbank_app.repository.FeedbackRepository;
import com.example.foodbank_app.repository.FoodbankRepository;
import com.example.foodbank_app.repository.PagingRepository;
import com.example.foodbank_app.web.dto.AdminRegistrationDto;
import com.example.foodbank_app.web.dto.BusinessRegistrationDto;
import com.example.foodbank_app.web.dto.FeedbackDto;
import com.example.foodbank_app.web.dto.UserRegistrationDto;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	private FoodbankRepository foodbankRepository;
	@Autowired
	private PagingRepository pagingRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FeedbackRepository feedRepository;
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(registrationDto.getUsername(), registrationDto.getFirstName(), registrationDto.getLastName(), 
				passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getDOB(), registrationDto.getPhoneNum(), 
				registrationDto.getEmail(),null, new HashSet<Role>(Arrays.asList(new Role("ROLE_USER"))), 50, registrationDto.getAddress(), 
				"N/A", registrationDto.getPriorityLeast(), registrationDto.getPriorityMiddle(), registrationDto.getPriorityMost(),
				"USER", "N/A", registrationDto.getVoucherCodes(), registrationDto.getMyDonations());
		
		return userRepository.save(user);
	}
	
	public User save(BusinessRegistrationDto businessRegistrationDto) {
		
		User user = new User(businessRegistrationDto.getUsername(), businessRegistrationDto.getFirstName(), 
				businessRegistrationDto.getLastName(), passwordEncoder.encode(businessRegistrationDto.getPassword()), 
				"N/A", businessRegistrationDto.getPhoneNum(), businessRegistrationDto.getEmail(),
				null, new HashSet<Role>(Arrays.asList(new Role("ROLE_FOODBANK"))), -1, businessRegistrationDto.getAddress(), 
				businessRegistrationDto.getDescription(), businessRegistrationDto.getPriorityLeast(), 
				businessRegistrationDto.getPriorityMiddle(), businessRegistrationDto.getPriorityMost(), 
				"FOODBANK", businessRegistrationDto.getDonateDetails(), "N/A", "N/A");
		
		return userRepository.save(user);
		
	}
	
	public User save(AdminRegistrationDto adminRegistrationDto) {
		
		User user = new User(adminRegistrationDto.getUsername(), adminRegistrationDto.getFirstName(), adminRegistrationDto.getLastName(), 
				passwordEncoder.encode(adminRegistrationDto.getPassword()), adminRegistrationDto.getDOB(), 
				adminRegistrationDto.getPhoneNum(), adminRegistrationDto.getEmail(), 
				null, new HashSet<Role>(Arrays.asList(new Role("ROLE_ADMIN"))), -2, adminRegistrationDto.getAddress(), "N/A", 
				adminRegistrationDto.getPriorityLeast(), adminRegistrationDto.getPriorityMiddle(), adminRegistrationDto.getPriorityMost(), 
				"N/A", "N/A", "N/A", "N/A");
		
		return userRepository.save(user);
	}
	
	public User Delete1(long id) {
		
        User username = userRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("Text", "id", id));

        userRepository.delete(username);
		return username;
		
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
	}
	
    public List<User> listAll() {
    	
        return userRepository.findAll();
    }

    public User get(long id) {
    	
        return userRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	
    	userRepository.deleteById(id);;
    }
    
    public void deleteuser(String id) {
    	
    	Long userid=userRepository.findByUsername(id).getid();
    	userRepository.deleteById(userid);
    }
    
	public Long loggedinuserid(Principal principal) {
		String username = principal.getName();
		Long userid=userRepository.findByUsername(username).getid();
		return userid;
	}
    
    public void save1(User user) {
    	
    	passwordEncoder.encode(user.getPassword());
        userRepository.save(user);
    }
		
       public void updateResetPasswordToken(String token,String email) throws UserWasNotFoundException {
		User user = userRepository.findByEmail(email);
		
		if (user != null) {
			user.setResetPasswordToken(token);
			userRepository.save(user);
		}
		else {
			throw new UserWasNotFoundException("No user was found with this email address");
		}
		
		
	}
	public User get(String resetPasswordToken) {
		return userRepository.findByResetPasswordToken(resetPasswordToken);
		
	}
	
	public void updatePassword(User user,String newPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		user.setPassword(encodedPassword);
		user.setResetPasswordToken(null);
		userRepository.save(user);
	
	}
	
	public Page<User> listAll1(int pageNum, String sortField, String sortDir, String keyword) {
	    int pageSize = 5;
	     Sort sort = Sort.by(sortField);
	     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
	    
	    if(keyword != null) {
	    	return pagingRepository.findAll(keyword, pageable);
	    	
	    }
	    return pagingRepository.findAll(pageable);
	}
	
	public Page<User> listAllFoodbanks(int pageNum, String sortField, String sortDir, String keyword) {
	    int pageSize = 5;
	     Sort sort = Sort.by(sortField);
	     sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
	    
	    if(keyword != null) {
	    	return foodbankRepository.findAll(keyword, pageable);
	    	
	    }
	    return foodbankRepository.findAll(pageable);
	}

	public Feedback save(FeedbackDto feedbackDto) {
		
		Feedback feedback1 = new Feedback(feedbackDto.getfeedback());
		
		return feedRepository.save(feedback1);
		
	}

	public List<Feedback> listAllfeedback() {
		
		return feedRepository.findAll();
	}
	
    public void deletefeedback(long id) {
    	
    	feedRepository.deleteById(id);;
    }
	
    public void sendprofileEmail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(email);
        msg.setSubject("Foodbank Profile Changes Saved Successfully");

        msg.setText("Hello! Your profile has successfully been changed on your Foodbank account.\n\n To view changes please login to your account. \n\n-The Foodbank Team");

        javaMailSender.send(msg);

        
    }
    public void sendDeletedEmail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(email);
        msg.setSubject("Foodbank account has been deleted");

        msg.setText("Hello! \n\n We are sorry to hear you leaving. We just wanted to update you that you Foodhub account has been successfully deleted.\n\n Thank you for helping to make a difference in people's life.\n\n - The Foodbank team -\n\n\nThis is an automated email, please do not reply back to this email, if you require further assisstance please email foodhub010@gmail.com.");

        javaMailSender.send(msg);

    }


     public void sendfeedbackEmail(String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setTo(email);
        msg.setSubject("New Feedback");

        msg.setText("Hello! \n\n You have a new feedback, please login to the admin page to view the feedback\n\n - This is an automated email, please do not reply back to this email");

        javaMailSender.send(msg);

    }
    
     public void sendRedeemEmail(String email, String redeemcode) {
         SimpleMailMessage msg = new SimpleMailMessage();
         
         msg.setTo(email);
         msg.setSubject("Your Redeem Codes");

         
         msg.setText("Hello! \n\n\n Please find your voucher codes below. \n\n\n\n"+redeemcode+"\n\n\n\n This is an automated email, please do not reply back to this email");

         javaMailSender.send(msg);

     }
    
    
    
    
}
