package com.ppooii.trabajot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class Trabajot1Application extends SpringBootServletInitializer {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Trabajot1Application.class, args);
		

	}

}
