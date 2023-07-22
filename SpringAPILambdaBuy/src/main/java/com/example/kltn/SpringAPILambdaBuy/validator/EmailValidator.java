package com.example.kltn.SpringAPILambdaBuy.validator;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator implements Predicate<String> {

	@Override
	public boolean test(String t) {
		// Regex to validate email
		return true;
	}
	
}
