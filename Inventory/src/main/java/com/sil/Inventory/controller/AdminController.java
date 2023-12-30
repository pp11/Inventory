package com.sil.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sil.Inventory.model.LoginModel;
import com.sil.Inventory.model.UserInfoModel;
import com.sil.Inventory.services.MyService;






@Controller

public class AdminController {

	@Autowired
	MyService myService;
	
	@GetMapping("/login")
    public String showLoginPage(Model model) {
		//model.addAttribute("pageName", "Welcome to Login Page");
        return "login";
    }
	
	@GetMapping("/home")
    public String showRegistrationPage(Model model) {
	//	model.addAttribute("pageName", "Welcome to Login Page");
        return "registration";
    }
	
	@GetMapping("/signUp")
    public String showIndexPage(Model model) {
	//	model.addAttribute("pageName", "Welcome to Login Page");
        return "register";
    }
	
	
	@PostMapping("/myLogin")	
	public ResponseEntity<String> myLogin(@RequestBody LoginModel request)
	{
		if(request.getUsername()==null) {
			return ResponseEntity.status(HttpStatus.OK).body("Invalid User");
		}
		else{
			
			myService.loginUser(request);
			return ResponseEntity.status(HttpStatus.OK).body("login Success");
			
		} 
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody UserInfoModel request) {
		
		if(request!=null) {
			
			System.out.println(request.toString());
			try {
				myService.insertUserInfo(request);
				return ResponseEntity.status(HttpStatus.OK).body("Success");
			}
			catch(Exception e){
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.OK).body("Failed");
				
			}
			
		}else {
			return ResponseEntity.status(HttpStatus.OK).body("Failed");
		}
		
		
	}

	 
}
