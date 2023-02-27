package com.example.garage_v2.controller;

import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;
import com.example.garage_v2.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping("/{id}")
    public OwnerGarage getOwner(@PathVariable int id) {
        return this.ownerService.getById(id);
    }

    @GetMapping
    public List<OwnerGarage> getOwners() {
        return this.ownerService.getOwners();
    }

    @PostMapping
    public void addOwner(@RequestBody Owner owner) {
        this.ownerService.addOwner(owner);
    }

    @PostMapping("/{ownerId}/{carId}")
    public void addCarToUser(@PathVariable int ownerId, @PathVariable int carId) {
        this.ownerService.addOwnersCar(ownerId,carId);
    }
}
