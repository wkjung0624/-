package com.p2pcenter.lendingmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LendingmachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(LendingmachineApplication.class, args);
	}

}
