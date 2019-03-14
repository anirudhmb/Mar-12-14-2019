package com.intuit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.service.AnagramService;
import com.intuit.service.PalindromeService;

@Controller
public class WordController {
	
	@Autowired
	private PalindromeService palindromeService;
	
	@Autowired
	private AnagramService anagramService;
	
	
	@PostMapping("/palindromecheck")
	public String checkForPalindrome(@RequestParam("word") String word, Model model) {
		boolean result = palindromeService.isPalindrome(word);
		if(result) {
			model.addAttribute("palindromemessage", word + " is a palindrome");
		}
		else {
			model.addAttribute("palindromemessage", word + " is not a palindrome");
		}
		return "index";
	}
	
	@PostMapping("/getanagram")
	public String getAnagram(@RequestParam("word") String word, Model model) {
		String result = anagramService.getJumbledWord(word);
		model.addAttribute("anagrammessage", result);
		return "index";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
