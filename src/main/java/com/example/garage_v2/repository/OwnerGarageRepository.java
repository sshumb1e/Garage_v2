package com.example.garage_v2.repository;

import com.example.garage_v2.model.OwnerGarage;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerGarageRepository extends CrudRepository<OwnerGarage, Integer> {

    @Query("""
            SELECT * FROM "owner" as t1
                FULL JOIN "car" as t2
                ON t1.owner_id = t2.owner_id
                WHERE t1.owner_id = (:id)
                ORDER BY t2.brand, t2.colour
            ;
            """)
    OwnerGarage findOwnerGarageById(@Param("id") int id);

    @Query("""
           SELECT * FROM "owner" as t1
                LEFT JOIN "car" as t2
                ON t1.owner_id = t2.owner_id
                ORDER BY t1.owner_id, t2.brand, t2.colour
           ;
           """)
    List<OwnerGarage> findAllOwnerGarage();


}
