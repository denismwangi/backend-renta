package com.renta.app.repository;


import com.renta.app.models.House;
import com.renta.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hibernate.FetchMode.JOIN;
import static org.hibernate.FetchMode.SELECT;
import static org.hibernate.hql.internal.antlr.SqlTokenTypes.FROM;



@Repository
@Transactional(readOnly = true)
public interface HousesRepository extends JpaRepository<House, Long> {



//    SELECT *FROM house LEFT JOIN users ON house.house_id = users.user_id;




}
