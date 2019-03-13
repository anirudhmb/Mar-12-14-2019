package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lab02Controller {

	@Autowired
	private Lab02Service lab02Service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/processword")
	public String processWord(@RequestParam String word, Model model) {
		String message = lab02Service.talkToPalindromeApp(word);
		model.addAttribute("message", message);
		return "index";
	}
	
}
