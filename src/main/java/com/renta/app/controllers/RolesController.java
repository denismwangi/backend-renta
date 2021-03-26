package com.renta.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renta.app.models.Role;
import com.renta.app.models.User;
import com.renta.app.repository.RoleRepository;
import com.renta.app.repository.UserRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class RolesController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@PostMapping("/roles/create")
	public Role createRole(@RequestBody Role role) {
		
		return roleRepository.save(role);
		
	}

	@GetMapping("/roles")
	public List<Role> getAllRoles(){
		
		return roleRepository.findAll();
	}
	

	

}


	