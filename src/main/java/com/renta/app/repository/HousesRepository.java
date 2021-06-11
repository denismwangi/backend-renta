package com.renta.app.repository;


import com.renta.app.models.House;
import com.renta.app.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;




@SuppressWarnings("JpaQlInspection")
@Repository
public interface HousesRepository extends JpaRepository<House, Long> {


    @Query(value = "select s from House s where location like %?1%")
    Page<House> findByLocation(String location, Pageable pageable);

    @Query(value = "select s from House s where category like %?1%")
    Page<House> findByCategory(String category, Pageable pageable);



//    SELECT *FROM house LEFT JOIN users ON house.house_id = users.user_id;




}
