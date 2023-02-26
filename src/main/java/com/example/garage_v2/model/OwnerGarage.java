package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerGarage {

    private int ownerId;
    private String ownerName;
    private String ownerCarBrand;
    private String ownerCarColour;
}
