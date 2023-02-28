package com.example.garage_v2.service;


import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)

public class CarServiceTest {

    @Mock
    public CarRepository carRepository;


    @Test
    public void addCarTest() {
        CarService carService = new CarService(carRepository);
        Car bmw = Car.builder().car_id(44).brand("BMW").colour("White").build();
        Mockito.when(carRepository.save(any())).thenReturn(bmw);
        Car ford = carService.addCar(new Car());
        Assertions.assertEquals(bmw, ford);
    }

    @Test
    public void findCarByIdTest() {
        CarService  carService =new CarService(carRepository);
        Car bmw = Car.builder().car_id(44).brand("BMW").colour("White").build();
        Mockito.when(carRepository.findById(any())).thenReturn(Optional.of(bmw));
        Car car = carService.getById(anyInt());
        Assertions.assertEquals(bmw, car);
    }


    @Test
    public void getCarsTest() {
        CarService  carService =new CarService(carRepository);
        Car bmw = Car.builder().car_id(44).brand("BMW").colour("White").build();
        Car nissan = Car.builder().car_id(25).brand("Nissan").colour("Black").build();
        List<Car> cars = new ArrayList<>();
        cars.add(bmw);
        cars.add(nissan);

        Mockito.when(carRepository.findAll()).thenReturn(cars);
        List<Car> carsAll = carService.getAll();
        Assertions.assertEquals(cars, carsAll
        );
    }


    @Test
    public void findByIdNotFoundTest() {
        CarService carService = new CarService(carRepository);

        Mockito.when(carRepository.findById(any())).thenReturn(Optional.empty());
        ResponseStatusException responseStatusException = Assertions.assertThrows(ResponseStatusException.class, () -> carService.getById(anyInt()));
        Assertions.assertEquals("404 NOT_FOUND", responseStatusException.getMessage());
    }


}
