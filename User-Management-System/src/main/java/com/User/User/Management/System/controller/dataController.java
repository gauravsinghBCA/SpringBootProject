package com.User.User.Management.System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.User.User.Management.System.entity.userData;
import com.User.User.Management.System.service.DataService;

import jakarta.servlet.http.HttpSession;

@Controller
public class dataController {
	
	@Autowired
	private DataService dataService;

	@GetMapping("/")
	public String showHme() {
		return "index";
	}
	
	@GetMapping("signin")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("register")
	public String showResister() {
		return "register";
	}
	
	@PostMapping("/createUser")
	public String creatData(@ModelAttribute userData user,HttpSession session) {
		
		boolean result = dataService.checkEmail(user.getEmail());
		if(result)
		{
			session.setAttribute("msg", "Email already exists");
			return "register";
		}
		else {
			userData userData = dataService.createData(user);
			if(userData!=null) {
				session.setAttribute("msg", "Registerd successfully");
			}else {
				session.setAttribute("msg", "Somthing wrong");
			}
			return "redirect:/register";
		}
		
		
	}
}
