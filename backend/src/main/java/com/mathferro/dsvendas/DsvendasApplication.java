package com.mathferro.dsvendas;

import com.mathferro.dsvendas.entities.Sale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mathferro.dsvendas.entities.Seller;

import java.util.stream.Collectors;

@SpringBootApplication
public class DsvendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsvendasApplication.class, args);
	}

}
