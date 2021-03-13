package com.renta.app.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;
import com.renta.app.repository.HouseRepository;

@Service
public class HouseStorage {
	
	@Autowired
	private static HouseRepository houseRepository;
	
	public static Houses store(MultipartFile file)throws IOException{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		Houses House = new Houses(fileName, file.getContentType(), fileName, file.getBytes(), fileName, fileName, fileName, fileName, fileName);
		
		
		return houseRepository.save(House);
		
	}
	
	public Houses getFile(String id) {
	    return houseRepository.findById(id).get();
	  }
	  
	  public Stream<Houses> getAllFiles() {
	    return houseRepository.findAll().stream();
	  }
	

}