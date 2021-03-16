package com.renta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.renta.app.models.Houses;

public interface HouseRepository extends JpaRepository<Houses, String> {

	//Houses save(MultipartFile file, Houses houses);

	//Houses save(MultipartFile file, Houses houses);

	//Houses save(MultipartFile file);

	//Houses save(Houses houses, MultipartFile file);

}