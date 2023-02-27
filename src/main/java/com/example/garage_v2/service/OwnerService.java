package com.example.garage_v2.service;


import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;

import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.OwnerGarageRepository;
import com.example.garage_v2.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final CarRepository carRepository;
    private final OwnerGarageRepository ownerGarageRepository;

    public OwnerService(OwnerRepository ownerRepository, CarRepository carRepository, OwnerGarageRepository ownerGarageRepository) {
        this.ownerRepository = ownerRepository;
        this.carRepository = carRepository;
        this.ownerGarageRepository = ownerGarageRepository;
    }


    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public OwnerGarage getById(int id) {
        return ownerGarageRepository.findOwnerGarageById(id);
    }

    public List<OwnerGarage> getOwners() {
        return ownerGarageRepository.findAllOwnerGarage();
    }

    public void addOwnersCar(int ownerId, int carId) {
        carRepository.updateOwnerCar(ownerId,carId);
    }
}
