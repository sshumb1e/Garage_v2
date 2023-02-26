package com.example.garage_v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private int id;
    private String brand;
    private String colour;



}
