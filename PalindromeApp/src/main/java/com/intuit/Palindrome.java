package com.intuit;

import org.springframework.stereotype.Component;

@Component
public class Palindrome {

	public boolean check(String word) {
		String[] reversedArr = word.split("");
		StringBuffer reversedWord = new StringBuffer(""); 
		for (int i = reversedArr.length - 1; i > -1; i--) {
			reversedWord.append(reversedArr[i]);
		}
		return word.equals(reversedWord.toString());
	}
}
