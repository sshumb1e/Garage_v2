package com.example.garage_v2.repository;


import com.example.garage_v2.model.Car;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    @Override
    List<Car> findAll();

    @Modifying
    @Query("""
           UPDATE public.car
                SET owner_id = (:ownerId)
                WHERE car_id = (:carId)
           ;
           """)
    void updateOwnerCar(@Param("ownerId") int userId, @Param("carId") int carId);



}
