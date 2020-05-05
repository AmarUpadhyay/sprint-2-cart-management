package com.capgemini.go;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
public class CartManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartManagementApplication.class, args);
	}

}
