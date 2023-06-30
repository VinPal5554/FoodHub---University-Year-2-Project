package com.example.foodbank_app.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.foodbank_app.model.Feedback;
import com.example.foodbank_app.model.User;
import com.example.foodbank_app.repository.FeedbackRepository;
import com.example.foodbank_app.repository.RoleRepository;
import com.example.foodbank_app.repository.UserRepository;
import com.example.foodbank_app.service.UserService;
import com.example.foodbank_app.web.dto.UserRegistrationDto;

import java.security.Principal;
import java.util.List;


@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
    @Autowired
    private UserService userservice;
	
    @GetMapping("/")
	public String landingpage() {
		return "index";
	}
    
    @GetMapping("/aboutus")
    public String aboutus() {
    	return "aboutus";
    }
    
//    @GetMapping("/feedback")
//    public String feedback() {
//    	return "feedback";
//    }
    
    @GetMapping("/homepage") 
	public String homepage() {
		return "homepage";
	}
    
    @GetMapping("/notFound")
    public String notFound() {
    	return "notFound";
    }
    
    @GetMapping("/businesshomepage")
	public String businesshomepage(Model model, Principal principal) {
    	
    	String username = principal.getName();
	    Long userid=userRepository.findByUsername(username).getid();
		model.addAttribute("user", userRepository.findById(userid).get());
		
		return "businesshomepage";
	}
    
//    @GetMapping("/adminhomepage")
//    public String adminhomepage() {
//    	return "adminhomepage";
//    }
    
	@GetMapping("/login")
	public String showloginpage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
		return "redirect:/homepage";
	}
	
	@GetMapping("/leaderboard")
    public String viewleaderboardPage(Model model) {
    	String keyword = null;
        return leaderboard(model, 1, "points", "desc", "USER");
        
	}
	@GetMapping("leaderboard/{pageNum}")
	public String leaderboard(Model model, @PathVariable(name = "pageNum") int pageNum, @Param("sortField") String sortField,
            @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
		
		Page<User> page = userservice.listAllFoodbanks(pageNum, sortField, sortDir, keyword);
        long totalUsers = page.getNumberOfElements();
        int totalPages = page.getTotalPages();
        List<User> listUsers = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        
        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
       
		return "leaderboard";
	}
	
	@GetMapping("/donationpage")
	public String donationpage() {
		return "donationpage";
	}
	
	@GetMapping("/redeem")
	public String redeem(Model model, Principal principal) {
		
		String username = principal.getName();
	    Long userid=userRepository.findByUsername(username).getid();
		model.addAttribute("user", userRepository.findById(userid).get());
		return "redeem";
	}  
	
	@RequestMapping("/foodbanks")
    public String viewFoodbankPage(Model model) {
		
    	String keyword = null;
        return foodbanks(model, 1, "id", "asc", "FOODBANK");
    }
	
	@GetMapping("foodbanks/{pageNum}")
	public String foodbanks(Model model, @PathVariable(name = "pageNum") int pageNum, @Param("sortField") String sortField,
            @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
		
		Page<User> page = userservice.listAllFoodbanks(pageNum, sortField, sortDir, keyword);
        long totalUsers = page.getNumberOfElements();
        int totalPages = page.getTotalPages();
        List<User> listUsers = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        
        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
       
		return "foodbanks";
	}
	
	@GetMapping("/pointtransaction") 
	public String pointtransaction(Model model) {
		
		String keyword = null;
        return givePoints(model, 1, "id", "asc", "USER");
		
	}
	
	@GetMapping("pointtransaction/{pageNum}")
	public String givePoints(Model model, @PathVariable(name = "pageNum") int pageNum, @Param("sortField") String sortField,
            @Param("sortDir") String sortDir, @Param("keyword") String keyword) {
		
		Page<User> page = userservice.listAllFoodbanks(pageNum, sortField, sortDir, keyword);
        long totalUsers = page.getNumberOfElements();
        int totalPages = page.getTotalPages();
        List<User> listUsers = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        
        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
       
		return "pointtransaction";
		
	}
	
	
//	@RequestMapping("/dummypage")
//	public String viewHomePage(Model model) {
//	    List<User> listUsers = userservice.listAll();
//	    model.addAttribute("listUsers", listUsers);
//	    
//	    return "dummypage";
//	}
	
	@GetMapping("/edit/{id}")
	public String showCreateNewUserForm(@PathVariable long id, Model model) {
		model.addAttribute("listRoles", roleRepository.findById(id).get());
		model.addAttribute("user", userRepository.findById(id).get());
		return "edit_user";
	}
	
	@GetMapping("/redeemtran/")
	public String redeemPage(Principal principal, Model model) {
		
		String username = principal.getName();
		long id = userRepository.findByUsername(username).getid();
		
	    
		model.addAttribute("listRoles", roleRepository.findById(id).get());
		model.addAttribute("user", userRepository.findById(id).get());
		return "redeemtransaction";
	}
	
	
	
//	@GetMapping("/redeem/{id}")
//	public String redeemPage(@PathVariable long id, Model model) {
//		
//		model.addAttribute("listRoles", roleRepository.findById(id).get());
//		model.addAttribute("user", userRepository.findById(id).get());
//		return "redeemtransaction";
//	}
	
	@GetMapping("/points/{id}")
	public String awardPoints(@PathVariable long id, Model model) {
		
		model.addAttribute("listRoles", roleRepository.findById(id).get());
		model.addAttribute("user", userRepository.findById(id).get());
		
		return "awardPoints";
		
	}
	

	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name = "id") long id) {
	    userservice.delete(id);
	    return "redirect:/adminhomepage";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user, Principal principal) {
	    userservice.save1(user);
	    String username = principal.getName();
	    String useremail=userRepository.findByUsername(username).getEmail();
	    userservice.sendprofileEmail(useremail);
	    return "redirect:/homepage";
	    
	}
	@PostMapping("/save5")
	public String saveRedeem(@ModelAttribute("user") User user, Principal principal) {	
		String username = principal.getName();
	    userservice.save1(user);
	    String vouchers = userRepository.findByUsername(username).getVoucherCodes();
	    String useremail=userRepository.findByUsername(username).getEmail();
	    userservice.sendRedeemEmail(useremail,vouchers);
	    return "redirect:/homepage";
	    
	}
	
	@PostMapping("/save2")
	public String savePriority(@ModelAttribute("user") User user) {
	    userservice.save1(user);
	    return "redirect:/businesshomepage";
	    
	}
	
	@PostMapping("/save3")
	public String saveuseradmin(@ModelAttribute("user") User user) {
	    userservice.save1(user);
	    return "redirect:/adminhomepage";
	    
	}
	
	@PostMapping("/save4")
	public String businessAward(@ModelAttribute("user") User user) {
		userservice.save1(user);
		return "redirect:/pointtransaction";
	}
	
	@RequestMapping("/deletebyuser")
	public String currentLoggedInUsername(Principal principal) {
		String username = principal.getName();
	    String useremail=userRepository.findByUsername(username).getEmail();
	    userservice.sendDeletedEmail(useremail);
		userservice.deleteuser(username);
		SecurityContextHolder.clearContext();
		return "redirect:/";
	}
	
    @GetMapping("/profilePage")
	public String showEditUser(Model model, Principal principal) {
    	String username = principal.getName();
	    Long userid=userRepository.findByUsername(username).getid();
	    
		model.addAttribute("listRoles", roleRepository.findById(userid).get());
		model.addAttribute("user", userRepository.findById(userid).get());
	    
	    return "userpage";
    }
    
    @RequestMapping("/adminhomepage")
    public String viewdummyadmin(Model model) {
    	String keyword = null;
        return viewPage(model, 1, "id", "asc", keyword);
    }
    
    @RequestMapping("/admin/{pageNum}")
    public String viewPage(Model model,
            @PathVariable(name = "pageNum") int pageNum,
            @Param("sortField") String sortField,
            @Param("sortDir") String sortDir,
            @Param("keyword") String keyword) {
        Page<User> page = userservice.listAll1(pageNum, sortField, sortDir, keyword);
        long totalUsers = page.getNumberOfElements();
        int totalPages = page.getTotalPages();
        List<User> listUsers = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
	    List<Feedback> feedback = userservice.listAllfeedback();
	    model.addAttribute("showfeedback", feedback);
        
        String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
        model.addAttribute("reverseSortDir", reverseSortDir);
        return "/admin";
    }
    
	@RequestMapping("/editbusiness")
	public String showbusinesseditpage(Principal principal, Model model) {
	    
	    String username=principal.getName();
	    Long userid = userRepository.findByUsername(username).getid();
	    
		model.addAttribute("listRoles", roleRepository.findById(userid).get());
		model.addAttribute("user", userRepository.findById(userid).get());
	    
	    return "businesseditpage";
	}
	
	@RequestMapping("/editadmin")
	public String showadmineditpage(Principal principal, Model model) {
	    
	    String username=principal.getName();
	    Long userid = userRepository.findByUsername(username).getid();
	    
		model.addAttribute("listRoles", roleRepository.findById(userid).get());
		model.addAttribute("user", userRepository.findById(userid).get());
	    
	    return "editadmin";
	}
	
	
	
	
	
	@RequestMapping("/deletefeedback/{id}")
	public String deletefeedback(@PathVariable(name = "id") long id) {
	    userservice.deletefeedback(id);
	    return "redirect:/adminhomepage";
	}
	
	
	
    
}
