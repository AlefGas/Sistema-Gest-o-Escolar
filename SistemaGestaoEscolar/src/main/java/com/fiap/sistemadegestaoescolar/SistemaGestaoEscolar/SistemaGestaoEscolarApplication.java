package com.fiap.sistemadegestaoescolar.SistemaGestaoEscolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SistemaGestaoEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaGestaoEscolarApplication.class, args);
	}
	
	@RequestMapping
	@ResponseBody
	public String home (){
		return "Teste";
	}
}
