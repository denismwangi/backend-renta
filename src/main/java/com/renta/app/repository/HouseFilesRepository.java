package com.renta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renta.app.models.houseImage;

public interface HouseFilesRepository extends JpaRepository<houseImage, String> {

}
