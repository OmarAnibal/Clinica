package com.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaBackupApplication.class, args);
		
		System.out.println("Mensaje nuevo");
	}

}
