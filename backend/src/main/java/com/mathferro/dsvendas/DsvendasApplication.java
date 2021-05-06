package com.mathferro.dsvendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mathferro.dsvendas.entities.Seller;

@SpringBootApplication
public class DsvendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsvendasApplication.class, args);
		
		var seller = new Seller();
		
	}

}
