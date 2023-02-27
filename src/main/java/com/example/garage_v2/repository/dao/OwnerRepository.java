package com.example.garage_v2.repository.dao;

import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;

import java.util.List;

public interface OwnerRepository {

    List<OwnerGarage> getOwner(int id);
    List<OwnerGarage> getAllOwners();
    void addOwner(Owner owner);
    void addCartoOwner(int ownerId, int carId);
}
