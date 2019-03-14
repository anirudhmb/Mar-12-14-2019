package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
public class AnagramController {

	@Autowired
	private Anagram anagram;
	
	@GetMapping("/{word}")
	public String getJumbledWord(@PathVariable String word) {
		return anagram.getJumbledWord(word);
	}
	
}
