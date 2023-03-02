package com.example.garage_v2.repository;

import com.example.garage_v2.model.OwnerRegistration;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistrationRepository extends CrudRepository<OwnerRegistration, String> {

    @Query("""
            SELECT * FROM "authorization"
            WHERE name = (:name);
            """)
    OwnerRegistration getByName(@Param("name") String name);

}
