package com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SistemaGestaoEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGestaoEscolarApplication.class, args);
	}
	
	
}
