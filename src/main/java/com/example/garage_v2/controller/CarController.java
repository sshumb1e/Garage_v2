package com.example.garage_v2.controller;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.service.CarService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "cars", key = "#id")
    public Car getCar(@PathVariable int id) {
        return this.carService.getById(id);
    }

    @GetMapping
    @Cacheable(value = "allCars")
    public List<Car> getCars() {
        return this.carService.getAll();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        this.carService.addCar(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.carService.remove(id);
    }
}
