package com.sil.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sil.Inventory.model.UserInfoModel;
import com.sil.Inventory.services.MyService;
import com.sil.Inventory.util.BaseResponse;





@Controller

public class AdminController {

	@Autowired
	MyService myService;
	
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
