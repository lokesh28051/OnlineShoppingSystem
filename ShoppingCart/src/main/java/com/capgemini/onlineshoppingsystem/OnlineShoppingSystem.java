package com.capgemini.onlineshoppingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineShoppingSystem {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingSystem.class, args);
	}

}
