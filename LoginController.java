package com.example.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        // Dummy check for user credentials (you should replace this with actual database check)
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "login";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String handleForgotPassword(String email, Model model) {
        // Logic for handling forgot password (e.g., send reset link via email)
        model.addAttribute("message", "Password reset link has been sent to your email.");
        return "forgot-password";
    }
}
