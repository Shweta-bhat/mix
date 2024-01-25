package com.fable.weatherall.Controllers;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fable.weatherall.Services.UserService;



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
        return "user";
    }
	
//	@GetMapping("/admin")
//	public String displayAdminDashboard() {
//        return "admin";
//    }
	
	@GetMapping("/about")
	public String displayAboutPage() {
        return "about";
    }
	
//	 @GetMapping("/user_dashboard")
//		public String userPage (Model model, Principal principal) {
//			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//			model.addAttribute("user", userDetails);
//			return "user";
//		}
		
		@GetMapping("/admin")
		public String adminPage (Model model, Principal principal) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("user", userDetails);
			return "admin";
		}
}