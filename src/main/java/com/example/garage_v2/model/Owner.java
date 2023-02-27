package com.example.garage_v2.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("owner")
public class Owner {

    @Id
    private int owner_id;
    private String name;
    private int age;
}
