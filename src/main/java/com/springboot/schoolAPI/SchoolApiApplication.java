package com.springboot.schoolAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.springboot.schoolAPI")
@SpringBootApplication
public class SchoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApiApplication.class, args);
	}

}
