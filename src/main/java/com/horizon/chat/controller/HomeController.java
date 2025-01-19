package com.horizon.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Chat Application!"); // Add dynamic data
        return "home"; // Return the Thymeleaf template name (homehome.html)
    }
}

