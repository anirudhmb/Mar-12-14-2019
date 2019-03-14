package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnagramService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${anagram.baseurl}")
	private String anagramBaseUrl;
	
	public String getJumbledWord(String word) {
		String url = anagramBaseUrl + "/" + word;
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		return responseEntity.getBody();
	}
}
