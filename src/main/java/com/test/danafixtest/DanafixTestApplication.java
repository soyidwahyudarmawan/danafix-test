package com.test.danafixtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DanafixTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanafixTestApplication.class, args);
	}

}
