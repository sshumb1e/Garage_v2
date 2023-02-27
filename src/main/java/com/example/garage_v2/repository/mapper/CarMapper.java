package com.example.garage_v2.repository.mapper;

import com.example.garage_v2.model.Car;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper {


    @Override
    public Car mapRow(ResultSet rows, int rowNum) throws SQLException {
        return Car.builder()
                .id(rows.getInt("car_id"))
                .brand(rows.getString("brand"))
                .colour(rows.getString("colour"))
                .build();
     }
}
