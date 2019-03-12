package com.intuit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {

	@PostMapping("/process")
	public String processName(@RequestParam("firstname") String firstName, HttpSession session) {
		String message = "Hi " + firstName + "!!!";
		session.setAttribute("message", message);
		return "result";
	}
	
	@GetMapping("/")
	public String index() {
		return "start";
	}
	
}
