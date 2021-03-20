package com.renta.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;
import com.renta.app.repository.HouseRepository;

@Service
public class FileStorageService {
	
	@Autowired
	  private HouseRepository houseRepository;

	  public Houses store(Houses houses, MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    
	    Houses Houses = new Houses(
	    		fileName,
	    		file.getContentType(), 
	    		file.getBytes(),
	    		houses.getCategory(),
	    		houses.getDescription(),
	    		houses.getPrice(),
	    		houses.getRoomSize(),
	    		houses.getLocation()
	    		
	    		);

	    return houseRepository.save(Houses);
	  }

	

//	  public FileDB getFile(String id) {
//	    return fileDBRepository.findById(id).get();
//	  }
//	  
//	  public Stream<FileDB> getAllFiles() {
//	    return fileDBRepository.findAll().stream();
//	  }

}
