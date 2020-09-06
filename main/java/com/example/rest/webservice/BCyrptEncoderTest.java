package com.example.rest.webservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCyrptEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i = 0; i<10; i++) {
		String value = encoder.encode("password@#123");
		System.out.println(value);
		}
	}
}
