package com.lambert.errorhandle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lambert.errorhandle.*")
public class ErrorhandleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorhandleApplication.class, args);
	}

}
