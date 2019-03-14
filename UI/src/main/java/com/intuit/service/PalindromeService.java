package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PalindromeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${palindrome.baseurl}")
	private String palindromeBaseUrl;
	
	@HystrixCommand(fallbackMethod="isPalindromeBackup")
	public boolean isPalindrome(String word) {
		String url = palindromeBaseUrl + "/" + word;
		ResponseEntity<Boolean> responseEntity = restTemplate.getForEntity(url, Boolean.class);
		return responseEntity.getBody();
	}
	
	public boolean isPalindromeBackup(String word) {
		System.out.println("-----In checkForPalindromeBackup method----");
		return false;
	}

}
