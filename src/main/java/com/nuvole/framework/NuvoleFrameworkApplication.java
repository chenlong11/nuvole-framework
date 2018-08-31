package com.nuvole.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NuvoleFrameworkApplication {

	public static ConfigurableApplicationContext ac;

	public static void main(String[] args) {

		NuvoleFrameworkApplication.ac = SpringApplication.run(NuvoleFrameworkApplication.class, args);
	}

}

