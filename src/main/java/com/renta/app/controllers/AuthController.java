package com.renta.app.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renta.app.models.ERole;
import com.renta.app.models.Role;
import com.renta.app.models.User;
import com.renta.app.payload.request.LoginRequest;
import com.renta.app.payload.request.SignupRequest;
import com.renta.app.payload.response.JwtResponse;
import com.renta.app.payload.response.MessageResponse;
import com.renta.app.repository.RoleRepository;
import com.renta.app.repository.UserRepository;
import com.renta.app.security.jwt.JwtUtils;
import com.renta.app.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, 
			 BindingResult bindingResult,
			 Model model) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getFirstname(),
												 userDetails.getLastname(),
												 userDetails.getEmail(), 
												 userDetails.getPhone(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest,
			 BindingResult bindingResult,
			 Model model){
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!", "0"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!", "0"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getFirstname(),
				             signUpRequest.getLastname(),
				             signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 signUpRequest.getPhone(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "landlord":
					Role landlordRole = roleRepository.findByName(ERole.LANDLORD)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(landlordRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!", "1"));
	}
}