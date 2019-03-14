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

@Controller
public class WordController {
	
	@Autowired
	private PalindromeService palindromeService;
	
	@Autowired
	private AnagramService anagramService;
	
	
	@PostMapping("/palindromecheck")
	@ResponseBody
	public String checkForPalindrome(@RequestParam("word") String word) {
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
	
	@PostMapping("/getanagram")
	@ResponseBody
	public String getAnagram(@RequestParam("word") String word) {
		String result = anagramService.getJumbledWord(word);
		return result;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
