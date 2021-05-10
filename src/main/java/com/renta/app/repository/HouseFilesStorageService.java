package com.renta.app.repository;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.exception.FileStorageException;
import com.renta.app.exception.FileUploadException;
import com.renta.app.models.Houses;
import com.renta.app.models.houseImage;
import com.renta.app.repository.HouseFilesRepository;


@Service
public class HouseFilesStorageService {
	
	@Autowired
	  private HouseFilesRepository filesRepository;

	  public houseImage store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    houseImage houseimg = new houseImage(fileName, file.getContentType(), file.getBytes());

	    return filesRepository.save(houseimg);
	  }

	  public houseImage getFile(Long id) {
	    return filesRepository.findById(id).get();
	  }
	  
	  public Stream<houseImage> getAllFiles() {
	    return filesRepository.findAll().stream();
	  }
	

}