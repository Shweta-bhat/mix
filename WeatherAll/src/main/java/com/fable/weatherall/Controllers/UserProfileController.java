package com.fable.weatherall.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fable.weatherall.Admin_User_Entities.User;
import com.fable.weatherall.DTOs.UserDTO;
import com.fable.weatherall.Services.UserService;


@Controller
public class UserProfileController {
	@Autowired
    private UserService userService;

    @GetMapping("/userprofile/{email}")
    public String showUserProfile(@PathVariable String email, Model model) {
    	model.addAttribute("user", userService.findByEmail(email));
        User user = userService.findByEmail(email);

        if (user != null) {
            model.addAttribute("user", user);
            return "user/profile";
        } else {
            // Handle the case where the user is not found
            return "error";
        }
    }

    @PostMapping("/userprofile/{email}/edit")
    public String editUserProfile(@PathVariable String email, UserDTO userDTO) {
        userService.updateUserByEmail(email, userDTO);
        return "redirect:/user/profile/" + email;
    }
}
