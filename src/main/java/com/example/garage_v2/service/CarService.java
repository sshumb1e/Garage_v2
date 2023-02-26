package com.example.garage_v2.service;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.dao.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car car) {
        this.carRepository.addCar(car);
    }

    public Car getCar(int id) {
        return this.carRepository.getCar(id);
    }

    public List<Car> getCars() {
        return this.carRepository.getAllCars();
    }
}
