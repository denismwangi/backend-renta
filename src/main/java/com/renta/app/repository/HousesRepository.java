package com.renta.app.repository;


import com.renta.app.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepository extends JpaRepository<House, Long> {

  //House save(House house, House houseimg);
}
