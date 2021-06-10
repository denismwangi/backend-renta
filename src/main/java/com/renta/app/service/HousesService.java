package com.renta.app.service;


import com.renta.app.models.House;
import com.renta.app.models.User;
import com.renta.app.repository.HousesRepository;
import com.renta.app.repository.UserRepository;
import com.renta.app.utils.imgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class HousesService {

    @Autowired
    HousesRepository housesRepository;
    @Autowired
    UserRepository userRepository;



    public String saveHouse(House house, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            // Get the file name, including the suffix
            String fileName = file.getOriginalFilename();

            // Store in this path: the path is under the static file in the project directory: (Note: this file may need to be created by yourself)
            // The reason for putting it under static is that it stores static file resources, that is, you can enter the local server address through the browser, and you can access it when adding the file name
            String imgUrl = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/images/";


            try {
                // This method is a package for writing files. In the util class, import the package and use it. The method will be given later
                imgUtil.fileupload(file.getBytes(), imgUrl, fileName);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Then create the corresponding entity class, add the following path, and then write through the database operation method
            House biaopath = new House();
            String imagePath = biaopath.setPath("http://localhost:8080/images/"+fileName);
            House property = new House(house.getId(), house.getCategory(), house.getRoomSize(), house.getPrice(), house.getLocation(), house.getDescription(),imagePath, house.getUserId());


            housesRepository.save(property);
          //housesRepository.save(house);


        }
        return "success";

    }

    public Optional<User> owner(Long id){

       return userRepository.findById(id);

    }





}
