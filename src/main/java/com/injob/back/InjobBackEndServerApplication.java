package com.injob.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class InjobBackEndServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjobBackEndServerApplication.class, args);
		System.out.println("Welcome to INJOB BACKEND SERVER \uD83D\uDE0E");
	}

}
