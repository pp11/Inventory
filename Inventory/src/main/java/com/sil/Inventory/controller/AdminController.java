package com.sil.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sil.Inventory.services.MyService;





@Controller

public class AdminController {

	
	
	@GetMapping("/login")
    public String showLoginPage(Model model) {
		model.addAttribute("pageName", "Welcome to Login Page");
        return "login";
    }
	
	@GetMapping("/signUp")
    public String showRegistrationPage(Model model) {
	//	model.addAttribute("pageName", "Welcome to Login Page");
        return "registration";
    }
	
	
		
	/*
	 * @PostMapping("/register") public ResponseEntity<String> addUser(@RequestBody
	 * UserInfoModel request) {
	 * 
	 * BaseResponse response=new BaseResponse(); if(request!=null) {
	 * 
	 * System.out.println(request.toString());
	 * response=myService.insertUserInfo(request);
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(response.getMessage());
	 * }else { return ResponseEntity.status(HttpStatus.OK).body("Failed"); }
	 * 
	 * 
	 * }
	 */
}
