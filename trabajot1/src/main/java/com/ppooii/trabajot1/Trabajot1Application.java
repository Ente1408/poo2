package com.ppooii.trabajot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ppooii.trabajot1")
public class Trabajot1Application {
	public static void main(String[] args) {
		SpringApplication.run(Trabajot1Application.class, args);
	}

}
