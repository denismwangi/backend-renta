package com.renta.app.controllers;


import com.renta.app.exception.ResourceNotFoundException;
import com.renta.app.models.House;
import com.renta.app.models.User;
import com.renta.app.repository.HousesRepository;
import com.renta.app.security.services.UserDetailsImpl;
import com.renta.app.service.HousesService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private HousesService housesService;
    @Autowired
    HousesRepository housesRepository;

    /**
     *
     * @param house
     * @param file
     * @return
     */

    @RequestMapping("/houses/create")
    @ResponseBody
    public String upload(House house, @RequestParam("file") MultipartFile file) {


        return housesService.saveHouse(house,file);

    }


    /**
     *
     * @return
     */

    @GetMapping("/houses")
    public Page<House> findAll(@RequestParam Optional<String> location,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<String> sortBy){

        return housesRepository.findByLocation(location.orElse("_"), PageRequest.of(page.orElse(0), 5,
                Sort.Direction.ASC, sortBy.orElse("id")));
    }
    @GetMapping("/houses/category")
    public Page<House> findCategory(@RequestParam Optional<String> category,
                               @RequestParam Optional<Integer> page,
                               @RequestParam Optional<String> sortBy){

        return housesRepository.findByCategory(category.orElse("_"), PageRequest.of(page.orElse(0), 5,
                Sort.Direction.ASC, sortBy.orElse("id")));
    }
    /**
     *
     *
     * @param id
     * @return
     */

    @GetMapping("/houses/{id}")
    public ResponseEntity<House> getHouse(@PathVariable Long id){

        House houses = housesRepository.findById(id).
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
    public ResponseEntity<House> updateHouse(@PathVariable Long id , @RequestBody House houseDetails){
        House houses = housesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("houses does ot exist with id:" + id));

        houses.setRoomSize(houseDetails.getRoomSize());
        houses.setCategory(houseDetails.getCategory());
        houses.setDescription(houseDetails.getDescription());
        houses.setLocation(houseDetails.getLocation());
        houses.setPrice(houseDetails.getPrice());
//			houses.sethPhoto(houseDetails.gethPath());

        House updateHouse = housesRepository.save(houses);
        return ResponseEntity.ok(updateHouse);
    }

    /**
     *
     * @param id
     * @return
     */

    @DeleteMapping("/houses/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteHouse(@PathVariable Long id){
        House houses = housesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("house does not exist with id: " +1d));
        housesRepository.delete(houses);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);



    }
}