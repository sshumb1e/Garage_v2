package com.example.garage_v2.repository;

import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;
import com.example.garage_v2.repository.dao.OwnerRepository;
import com.example.garage_v2.repository.mapper.CarMapper;
import com.example.garage_v2.repository.mapper.OwnerMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {


    private final JdbcTemplate jdbcTemplate;

    public OwnerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String selectUser = """
            SELECT * FROM public.owner as t1
                FULL JOIN public.car as t2
                ON t1.owner_id = t2.owner_id
                WHERE t1.id =
            """;

    private static final String selectAllUsers = """
            SELECT * FROM public.owner as t1
                LEFT JOIN public.car as t2
                ON t1.owner_id = t2.owner_id
                ORDER BY t1.owner_id ASC, t2.brand ASC, t2.colour ASC
            """;

    private static final String insertUser = """
            INSERT INTO public.owner(
                name, age)
                VALUES (?, ?)
            """;

    private static final String addUserCar = """
            UPDATE public.car
                SET owner_id = (?)
                WHERE owner_id = (?)
            """;


    @Override
    public List<OwnerGarage> getOwner(int id) {
        return jdbcTemplate.query(selectUser + id, new OwnerMapper());
    }

    @Override
    public List<OwnerGarage> getAllOwners() {
        return jdbcTemplate.query(selectAllUsers, new OwnerMapper());
    }

    @Override
    public void addOwner(Owner owner) {
        jdbcTemplate.update(insertUser, owner.getName(), owner.getAge());

    }
    @Override
    public void addCartoOwner(int ownerId, int carId) {

        jdbcTemplate.update(addUserCar, ownerId, carId);
    }
}
