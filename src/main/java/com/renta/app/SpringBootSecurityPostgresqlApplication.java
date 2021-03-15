package com.renta.app;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renta.app.controllers.HouseController;

@SpringBootApplication
public class SpringBootSecurityPostgresqlApplication {

	public static void main(String[] args) {
		
		//new File(HouseController.uploadDirectory).mkdir(); 
		SpringApplication.run(SpringBootSecurityPostgresqlApplication.class, args);
	}

}
