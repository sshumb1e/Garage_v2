package com.example.garage_v2.controller;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.service.CarService;
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
    public Car getCar(@PathVariable int id) {
        return this.carService.getCar(id);
    }

    @GetMapping
    public List<Car> getCars() {
        return this.carService.getCars();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        this.carService.addCar(car);
    }
}
