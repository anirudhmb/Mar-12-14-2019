package com.intuit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.service.AnagramService;
import com.intuit.service.PalindromeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Controller
public class WordController {
	
	@Autowired
	private PalindromeService palindromeService;
	
	@Autowired
	private AnagramService anagramService;
	
	
	@PostMapping("/palindromecheck")
	@ResponseBody
	//@HystrixCommand(fallbackMethod="checkForPalindromeBackup")
	public String checkForPalindrome(@RequestParam("word") String word) {
		System.out.println("*****In actual checkForPalindrome method***");
		boolean result = palindromeService.isPalindrome(word);
		String message = "";
		if(result) {
			message = word + " is a palindrome";
		}
		else {
			message = word + " is not a palindrome";
		}
		return message;
	}
	
	public String checkForPalindromeBackup(String word) {
		System.out.println("-----In checkForPalindromeBackup method----");
		return "Service may be temporarily down. Try later";
	}
	
	
	@PostMapping("/getanagram")
	@ResponseBody
	@HystrixCommand(fallbackMethod="getAnagramBackup", commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", 
								value="6000")
	})
	public String getAnagram(@RequestParam("word") String word) {
		String result = anagramService.getJumbledWord(word);
		return result;
	}
	
	public String getAnagramBackup(String word) {
		return "Service is taking too much time to respond. Please try later.";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
