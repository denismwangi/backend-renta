package com.renta.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renta.app.exception.ResourceNotFoundException;
import com.renta.app.models.Houses;
import com.renta.app.models.User;
import com.renta.app.payload.response.HouseResponseFile;
import com.renta.app.payload.response.MessageResponse;
import com.renta.app.repository.HouseRepository;
import com.renta.app.service.HouseFilesStorageService;
import com.renta.app.service.HouseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class HouseController {
	
		@Autowired
        HouseRepository houseRepository;
		@Autowired 
		HouseFilesStorageService storageService;
		
		
		@Autowired
	    HouseService houseService;
		
		@PostMapping("/houses/create")
		public ResponseEntity<MessageResponse> saveHouse(Houses houses, @RequestParam("file") MultipartFile file){
			String message = "";
			try {
				storageService.store(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			houseService.saveHouse(houses);
			message = "created successfully: ";
	       return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message, "1"));
		
			
		}
		
	
//		
		/**
		 * 
		 * @return all the houses
		 */
		
		@GetMapping("/houses")
		public List<Houses> allHouses() {
			
			return  houseRepository.findAll();
		}
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		
		@GetMapping("/houses/{id}")
		public ResponseEntity<Houses> getHouse(@PathVariable String id){
			 
			Houses houses = houseRepository.findById(id).
					orElseThrow(() -> new ResourceNotFoundException("house not exist with id :" + id));
			return ResponseEntity.ok(houses);
			
		}
		
		
		/**
		 * 
		 * @param id
		 * @param houseDetails
		 * @return
		 */
		
		@PutMapping("/houses/{id}")
		public ResponseEntity<Houses> updateHouse(@PathVariable String id , @RequestBody Houses houseDetails){
			Houses houses = houseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("houses does ot exist with id:" + id));
			
			houses.setRoomSize(houseDetails.getRoomSize());
			houses.setCategory(houseDetails.getCategory());
			houses.setDescription(houseDetails.getDescription());
			houses.setLocation(houseDetails.getLocation());
			houses.setPrice(houseDetails.getPrice());
//			houses.sethPhoto(houseDetails.gethPhoto());
		
			Houses updateHouse = houseRepository.save(houses);
			return ResponseEntity.ok(updateHouse);
		}
		
		
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		
		@DeleteMapping("/houses/{id}")
		public ResponseEntity<Map<String , Boolean>> deleteHouse(@PathVariable String id){
			Houses houses = houseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("house does not exist with id: " +1d));
			houseRepository.delete(houses);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
			
		}
		
}




















