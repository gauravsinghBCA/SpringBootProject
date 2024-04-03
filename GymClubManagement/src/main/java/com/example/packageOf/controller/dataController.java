package com.example.packageOf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.packageOf.entity.bodyBuilder;
import com.example.packageOf.service.dataService;

@Controller
public class dataController {

	@Autowired
	private dataService dataService;
	
	@GetMapping("/")
	public String showPage(Model model) {
		bodyBuilder joiner = new bodyBuilder();
		model.addAttribute("joiner", joiner);
		return "index";
	}
	
	@PostMapping("/save")
	public String saveData(@ModelAttribute("joiner") bodyBuilder joiner , BindingResult bindingResult) {
		dataService.saveData(joiner);
		return "redirect:/";
	}
	
}
