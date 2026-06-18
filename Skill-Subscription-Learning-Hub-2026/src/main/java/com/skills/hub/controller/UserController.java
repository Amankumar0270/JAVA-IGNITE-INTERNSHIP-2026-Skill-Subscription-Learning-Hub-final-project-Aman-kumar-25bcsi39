package com.skills.hub.controller;

import com.skills.hub.model.User;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
=========================================================
WHAT IS THIS FILE?
Handles user actions like register and login
=========================================================
*/

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, org.springframework.ui.Model model) {
        User registered = userService.registerUser(user);
        if (registered != null) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Email already exists!");
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                         @RequestParam String password,
                         jakarta.servlet.http.HttpSession session,
                         org.springframework.ui.Model model) {
        User user = userService.login(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/packs";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(jakarta.servlet.http.HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

	public UserService getUserService() {
		return userService;
	}
}