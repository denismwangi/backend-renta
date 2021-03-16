package com.renta.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.exception.ResourceNotFoundException;
import com.renta.app.models.Houses;
import com.renta.app.models.User;
import com.renta.app.payload.response.MessageResponse;
import com.renta.app.repository.HouseRepository;

@CrossOrigin("http://127.0.0.1:8080/api/v1/house/")
@RestController
@RequestMapping("/api/v1/house")
public class HouseController {
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/images";
		@Autowired
        HouseRepository houseRepository;
		
		
		/**
		 * upload multiple images
		 * @param houses
		 * @param files
		 * @return
		 */
		@RequestMapping("/create")
		@ResponseBody
	     ResponseEntity<MessageResponse>  saveHouses(Houses houses, @RequestParam("image") MultipartFile[] files) {
			 StringBuilder fileNames = new StringBuilder();
			 String message;
			 for(MultipartFile file : files) {
				 
				 
				 String filename = houses.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
				 Path fileNameAndPath = Paths.get(uploadDirectory, filename);
				 
				 try {
					 Files.write(fileNameAndPath, file.getBytes());
				 }catch(IOException e){
					 e.printStackTrace();
					 
				 }
				 
				 houses.sethPhoto(filename);
				 houseRepository.save(houses);
        	      
				 
			 }
			 message = "saved  successfully: " ;
			 return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		
		}
		/**
		 * 
		 * @return all the houses
		 */
		
		@GetMapping("/allhouses")
		public List<Houses> allHouses() {
			
			return  houseRepository.findAll();
		}
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		
		@GetMapping("/house/{id}")
		public ResponseEntity<Houses> getUser(@PathVariable Long id){
			 
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
		
		@PutMapping("/house/{id}")
		public ResponseEntity<Houses> updateHouse(@PathVariable Long id , @RequestBody Houses houseDetails){
			Houses houses = houseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("houses does ot exist with id:" + id));
			
			houses.setRoomSize(houseDetails.getRoomSize());
			houses.setCategory(houseDetails.getCategory());
			houses.setDescription(houseDetails.getDescription());
			houses.setLocation(houseDetails.getLocation());
			houses.setPrice(houseDetails.getPrice());
			houses.sethPhoto(houseDetails.gethPhoto());
			
			
			
			Houses updateHouse = houseRepository.save(houses);
			return ResponseEntity.ok(updateHouse);
		}
		
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		
		@DeleteMapping("/house/{id}")
		public ResponseEntity<Map<String , Boolean>> deleteHouse(@PathVariable Long id){
			Houses houses = houseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("house does not exist with id: " +1d));
			houseRepository.delete(houses);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
			
		}
		
}




















