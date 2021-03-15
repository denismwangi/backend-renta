package com.renta.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;
import com.renta.app.repository.HouseRepository;

@CrossOrigin("http://127.0.0.1:8080/api/v1/house/")
@RestController
@RequestMapping("/api/v1/house")
public class HouseController {
	
	
	public static String uploadDirectory = System.getProperty("house.dir")+ "/src/main/resources/images";
		@Autowired
        HouseRepository houseRepository;
		
		@RequestMapping("create")
		@ResponseBody
		public String  saveHouses(Houses houses, @RequestParam("image") MultipartFile file) {
			 StringBuilder fileNames = new StringBuilder();
			 String filename = houses.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
			 Path fileNameAndPath = Paths.get(uploadDirectory, filename);
			 
			 try {
				 Files.write(fileNameAndPath, file.getBytes());
			 }catch(IOException e){
				 e.printStackTrace();
				 
			 }
			 houses.sethPhoto(filename);
			 houseRepository.save(houses);
			 
			 return "saved successsfuly";
			 
			
		}
		
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
//	
//	@PostMapping("/create")
//	ResponseEntity<MessageResponse> Save(Houses houses, @RequestParam("file") MultipartFile file) {
//		
//	   String message = "";
//	    	
//	      try {
//			HouseStorage.store(houses, file);
//
//	      message = "saved the file successfully: " + file.getOriginalFilename();
//	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
//	      
//	    } catch (Exception e) {
//      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
//	    }
//	      
//	  }
	
	

}
