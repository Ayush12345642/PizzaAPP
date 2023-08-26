package com.example.UserPizzaService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

public class UserPizzaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPizzaServiceApplication.class, args);
	}

}
