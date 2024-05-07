package org.example.electradrivebackend.api;

import org.example.electradrivebackend.dto.CarResponse;
import org.example.electradrivebackend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public List<CarResponse> getAllCars() {
        System.out.println("Trying to get all cars. Endpoint hit in CarController.");
        return carService.getAllCars();
    }
}

