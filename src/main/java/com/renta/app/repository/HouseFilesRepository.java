package com.renta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renta.app.models.houseImage;

@Repository
public interface HouseFilesRepository extends JpaRepository<houseImage, Long> {
//	houseImage findImageId(String imageId);

}
