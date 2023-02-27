package com.example.garage_v2.repository.mapper;

import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper implements RowMapper<OwnerGarage> {
    @Override
    public OwnerGarage mapRow(ResultSet rows, int rowNum) throws SQLException {
        return OwnerGarage.builder()
                .ownerId(rows.getInt("owner_id"))
                .ownerName(rows.getString("name"))
                .ownerCarBrand(rows.getString("brand"))
                .ownerCarColour(rows.getString("colour"))
                .build();
    }
}
