package com.example.garage_v2.service;


import com.example.garage_v2.model.Car;
import com.example.garage_v2.model.Owner;
import com.example.garage_v2.model.OwnerGarage;
import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.OwnerGarageRepository;
import com.example.garage_v2.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class OwnerServiceTest {
    @Mock
    public OwnerRepository ownerRepository;

    @Mock
    public OwnerGarageRepository ownerGarageRepository;

    @Mock
    public CarRepository carRepository;


    @Test
    public void addOwnerTest() {
        OwnerService ownerService =new OwnerService(ownerRepository,carRepository,ownerGarageRepository);
        Owner jhone = new Owner();
        jhone.setOwner_id(100);
        jhone.setName("Jhone");
        jhone.setAge(22);

        Mockito.when(ownerRepository.save(any())).thenReturn(jhone);
        Owner fakeUser = ownerService.addOwner(null);
        Assertions.assertEquals(jhone, fakeUser);
    }

    @Test
    public void getOwnerTest() {
        OwnerService ownerService =new OwnerService(ownerRepository,carRepository,ownerGarageRepository);
        OwnerGarage ownerGarage = OwnerGarage.builder().ownerId((2)).ownerName("Jhone").ownerCarBrand("BMW").ownerCarColour("White").build();

        Mockito.when(ownerGarageRepository.findOwnerGarageById(anyInt())).thenReturn(ownerGarage);
        OwnerGarage secondOwner = ownerService.getById(anyInt());
        Assertions.assertEquals(ownerGarage, secondOwner);
    }

    @Test
    public void getOwnersTest() {
        OwnerService ownerService =new OwnerService(ownerRepository,carRepository,ownerGarageRepository);
        OwnerGarage firstUserGarage = OwnerGarage.builder().ownerId(60).ownerName("Tom").ownerCarBrand("Audi").ownerCarColour("red").build();
        OwnerGarage secondUserGarage = OwnerGarage.builder().ownerId(70).ownerName("Tom").ownerCarBrand("Audi").ownerCarColour("white").build();
        List<OwnerGarage> ownerGarages = new ArrayList<>();
        ownerGarages.add(firstUserGarage);
        ownerGarages.add(secondUserGarage);

        Mockito.when(ownerGarageRepository.findAllOwnerGarage()).thenReturn(ownerGarages);
        List<OwnerGarage> ownersGarge = ownerService.getOwners();
        Assertions.assertEquals(ownerGarages, ownersGarge);
    }

    @Test
    public void addCarToUserTest() {
        Owner tom = new Owner();
        tom.setOwner_id(22);
        tom.setName("Tom");
        Car focus = Car.builder().car_id(72).brand("Ford").colour("red").build();

        OwnerGarage johnsGarage = OwnerGarage.builder().ownerId(22).ownerName("Tom").ownerCarBrand("Ford").ownerCarColour("red").build();
        OwnerGarage garage = updateUserCar(tom, focus);

        Assertions.assertEquals(johnsGarage, garage);
    }

    private OwnerGarage updateUserCar(Owner owner, Car car) {
        return OwnerGarage.builder()
                .ownerId(owner.getOwner_id())
                .ownerName(owner.getName())
                .ownerCarBrand(car.getBrand())
                .ownerCarColour(car.getColour())
                .build();
    }
}
