package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
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
