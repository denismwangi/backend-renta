package com.renta.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renta.app.models.Houses;

public interface HouseRepository extends JpaRepository<Houses, String> {

}
