package com.renta.app.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;
import com.renta.app.repository.HouseRepository;

@Service
public class HouseStorage {
	
//	@Autowired
//	private static HouseRepository houseRepository;
//	
//	
//	
//	public static Houses store(Houses houses, MultipartFile file)throws IOException{
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		
//		
//		Houses Houses = new Houses(fileName,
//				file.getContentType(), 
//				houses.getName(),
//				file.getBytes(),
//				houses.getDescription(),
//				houses.getCategory(), 
//				houses.getLocation(),
//				houses.getPrice(),
//				houses.getRoomSize());
//		
//		//Path targetLocation = ths.fileStorageLocation.resolve(fileName);
//		return houseRepository.save(Houses);
//		
//	}
//	
//	public Houses getFile(String id) {
//	    return houseRepository.findById(id).get();
//	  }
//	  
//	  public Stream<Houses> getAllFiles() {
//	    return houseRepository.findAll().stream();
//	  }
	

}