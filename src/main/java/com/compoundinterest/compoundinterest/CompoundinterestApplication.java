package com.compoundinterest.compoundinterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CompoundinterestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompoundinterestApplication.class, args);
	}

}
