package com.codegym.c07blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class C07BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(C07BlogApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "123secure@Password";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);
	}

}
