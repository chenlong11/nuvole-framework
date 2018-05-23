package com.nuvole.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Order(6)
public class NuvoleFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(NuvoleFrameworkApplication.class, args);
	}

}

