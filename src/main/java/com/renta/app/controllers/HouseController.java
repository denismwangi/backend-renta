package com.renta.app.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;
import com.renta.app.models.User;
import com.renta.app.payload.response.MessageResponse;
import com.renta.app.repository.HouseRepository;
import com.renta.app.service.HouseStorage;

@CrossOrigin("http://127.0.0.1:8080/api/v1/house/")
@RestController
@RequestMapping("/api/v1/house")
public class HouseController {
	
	
	
	
//	@Autowired
//	HouseRepository houseRepository;
//
		
//		@PostMapping("/create")
//		public Houses createHouse(Houses houses, 
//				@RequestParam("image") MultipartFile multipartFile) throws IOException{
//			
//			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//			
//	        houses.setPhotos(fileName);
//	         
//	        User savedUser = repo.save(user);
//	 
//	        String uploadDir = "user-photos/" + savedUser.getId();
//	 
//	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//			
//			//return HouseRepository.save(houses);
//			
//		}
////		
	
	@PostMapping("/create")
	ResponseEntity<MessageResponse> Save(Houses houses, @RequestParam("file") MultipartFile file) {
		
	   String message = "";
	    	
	      try {
			HouseStorage.store(houses, file);

	      message = "saved the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
	      
	    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
	    }
	      
	  }

}
