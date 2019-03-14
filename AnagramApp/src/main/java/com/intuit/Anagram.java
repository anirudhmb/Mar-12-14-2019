package com.intuit;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Anagram {

	public String getJumbledWord(String word) {
		String[] letters = word.split("");
		List<String> lettersList = Arrays.asList(letters);
		Collections.shuffle(lettersList);
		StringBuffer sb = new StringBuffer("");
		lettersList.forEach(it -> sb.append(it));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
