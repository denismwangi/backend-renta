package com.renta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;


@Repository
public interface HouseRepository extends JpaRepository<Houses, String> {



}
