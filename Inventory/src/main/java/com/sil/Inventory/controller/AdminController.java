package com.sil.Inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	
	@GetMapping("/login")
    public String showLoginPage(Model model) {
		model.addAttribute("pageName", "Welcome to Login Page");
        return "login";
    }
}
