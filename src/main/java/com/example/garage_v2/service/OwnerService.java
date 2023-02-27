package com.example.garage_v2.service;


import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;
import com.example.garage_v2.repository.dao.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public List<OwnerGarage> getOwner(int id) {
        return this.ownerRepository.getOwner(id);
    }

    public List<OwnerGarage> getOwners() {
        return this.ownerRepository.getAllOwners();
    }

    public void addOwner(Owner owner) {
        this.ownerRepository.addOwner(owner);
    }

    public void addCarToOwner(int ownerId, int carId) {
        this.ownerRepository.addCartoOwner(ownerId, carId);
    }
}
