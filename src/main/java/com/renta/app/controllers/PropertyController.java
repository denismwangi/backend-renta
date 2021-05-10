package com.renta.app.controllers;


import com.renta.app.exception.ResourceNotFoundException;
import com.renta.app.models.House;
import com.renta.app.models.Houses;
import com.renta.app.models.houseImage;
import com.renta.app.payload.response.HouseResponse;
import com.renta.app.payload.response.HouseResponseFile;
import com.renta.app.payload.response.MessageResponse;
import com.renta.app.repository.HousesRepository;
import com.renta.app.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private HousesService housesService;
    @Autowired
    private HousesRepository housesRepository;

    /**
     *
     * @param houses
     * @param file
     * @return
     */
    @PostMapping("prop/upload")
    public ResponseEntity<MessageResponse> uploadFile(House houses, @RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            housesService.storeHouse(houses, file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message, "1"));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message, "1"));
        }
    }

    @GetMapping("/prop")
    public ResponseEntity<List<HouseResponse>> getListFiles() {
        List<HouseResponse> files;
        files = housesService.getAllFiles().map(dbFile -> {

            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/api/v1/prop/")
                    .path(String.valueOf(dbFile.getId()))
                    .toUriString();

                  return new HouseResponse(
                    dbFile.getId(),
                    dbFile.getCategory(),
                    dbFile.getRoomSize(),
                    dbFile.getPrice(),
                    dbFile.getLocation(),
                    dbFile.getDescription(),
                    fileDownloadUri
                  );
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/house")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        House houseimg = housesService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + houseimg.getName() + "\"")
                .body(houseimg.getData());

    }

    @GetMapping("/prop/house")
    public List<House> allHouse(){

        return housesRepository.findAll();

    }
    @GetMapping("/prop/{id}")
    public ResponseEntity<House> getHouse(@PathVariable Long id){

        House houses = housesRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("house not exist with id :" + id));
        return ResponseEntity.ok(houses);

    }

}
