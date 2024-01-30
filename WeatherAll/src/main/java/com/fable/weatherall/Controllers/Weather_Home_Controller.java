package com.fable.weatherall.Controllers;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fable.weatherall.Admin_User_Entities.Admin;
import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.Repos.UserRepo;
import com.fable.weatherall.Services.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class Weather_Home_Controller {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	

	@GetMapping("/home")
    public String displayHome() {
        return "Homepage";
    }
	
	@GetMapping("/userlogin")
	public String displayLogin() {
        return "comlogin";
    }
	
	@GetMapping("/signup")
	public String displaySignup() {
        return "signup";
    }
	
	@GetMapping("/u_dashboard")
	public String displayUserDashboard() {
		System.out.println("Hi");
        return "user";
    }
	
	@GetMapping("/admin")
	public String displayAdminDashboard() {
        return "admin";
    }
	
	@GetMapping("/u_profile")
	public String displayuserpPage() {
        return "userprofile";
    }
	
	
//	@GetMapping("/u_profile")
//    public String viewUserProfile(Model model) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String email = auth.getName(); // Get the email of the currently logged-in user
//        User user = userService.findByEmail(email);
//
//        model.addAttribute("user", user);
//        return "userprofile";
//   }
	
//	@GetMapping("/edit_profile")
//	public String displayusereditPage() {
//        return "userprofile";
//   }
	
	@GetMapping("/about")
	public String displayAboutPage() {
        return "about";
    }
	
	@GetMapping("/feedback")
	public String displayfeedbackPage() {
        return "s_feedback";
    }
	
	
//	 @GetMapping("/user_dashboard")
//		public String userPage (Model model, Principal principal) {
//			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//			model.addAttribute("user", userDetails);
//			return "user";
//		}
//		
//		@GetMapping("/admin")
//		public String adminPage (Model model, Principal principal) {
//			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//			model.addAttribute("user", userDetails);
//			return "admin";
//		}
}