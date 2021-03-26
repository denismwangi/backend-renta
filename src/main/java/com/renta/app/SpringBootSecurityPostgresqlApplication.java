package com.renta.app;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.renta.app.models.Role;
import com.renta.app.repository.RoleRepository;
import com.renta.app.service.HouseFilesStorageService;

@SpringBootApplication
public class SpringBootSecurityPostgresqlApplication  {

	
	@Resource
	HouseFilesStorageService houseFilesStorageService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootSecurityPostgresqlApplication.class, args);
		
		
	}

	

	

	

}
