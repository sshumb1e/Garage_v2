package com.example.garage_v2.service;


import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(NOT_FOUND));
    }
    public void remove(Integer id) {
        carRepository.deleteById(id);
    }


}
