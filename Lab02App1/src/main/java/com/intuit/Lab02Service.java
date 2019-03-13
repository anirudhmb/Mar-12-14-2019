package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Lab02Service {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${palindrome.baseurl}")
	private String baseUrl;
	
	public String talkToPalindromeApp(String word) {
		String url = baseUrl + "/" + word;
		ResponseEntity<Boolean> responseEntity = 
				restTemplate.getForEntity(url, Boolean.class);
		boolean result = responseEntity.getBody();
		String message = word + " is ";
		if(result) {
			message += "a ";
		}
		else {
			message += "not a ";
		}
		message += "palindrome";
		return message;
	}
}
