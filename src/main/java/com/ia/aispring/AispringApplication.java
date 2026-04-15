package com.ia.aispring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.ia.aispring" })
public class AispringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AispringApplication.class, args);
	}

}
