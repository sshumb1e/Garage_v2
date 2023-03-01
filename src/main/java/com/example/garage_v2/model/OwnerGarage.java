package com.example.garage_v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("car")
@AllArgsConstructor
@NoArgsConstructor
public class OwnerGarage {

    @Column("owner_id")
    private int ownerId;
    @Column("name")
    private String ownerName;
    @Column("brand")
    private String ownerCarBrand;
    @Column("colour")
    private String ownerCarColour;
}
