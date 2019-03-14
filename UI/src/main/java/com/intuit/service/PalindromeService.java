package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PalindromeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${palindrome.baseurl}")
	private String palindromeBaseUrl;
	
	public boolean isPalindrome(String word) {
		String url = palindromeBaseUrl + "/" + word;
		ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url, Boolean.class);
		return responseEntity.getBody();
	}

}
