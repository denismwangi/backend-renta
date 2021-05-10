package com.renta.app.service;


import com.renta.app.models.House;
import com.renta.app.models.houseImage;
import com.renta.app.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class HousesService {

    @Autowired
    private HousesRepository housesRepo;

    /**
     *
     * @param house
     * @param file
     * @return
     * @throws IOException
     * stores the house
     */

    public House storeHouse(House house, MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        House houseimg = new House(house.getCategory(), house.getRoomSize(), house.getPrice(), house.getLocation(), house.getDescription(),fileName, file.getContentType(), file.getBytes());
        return housesRepo.save( houseimg);
    }

    /**
     *
     * @param id
     * @return single house
     */
    public House getFile(Long id) {
        return housesRepo.findById(id).get();
    }

    /**
     *
     * @return all houses
     */
    public Stream<House> getAllFiles() {

        return housesRepo.findAll().stream();
    }

}
