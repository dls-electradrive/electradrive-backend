package org.example.electradrivebackend.api;

import org.example.electradrivebackend.dto.CarDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/car")
public class CarController {


    @GetMapping("/")
    //Return json object with car data
    public String getCarData() {
        return "Car data";
    }

    @PostMapping("/sendCarData")
    public CarDto createCar(@RequestBody CarDto carDto) {
        // You now have a CarDto object populated with the data from the JSON object
        // You can now use this object to perform your business logic

        return carDto; // For now, let's just return the received object
    }


    //TODO: Add more endpoints for car data
    //TODO: Add endpoint for Elastic Search

    //TODO: a penguin is a bird and a bird is an animal and an animal is a living thing but a penguin is not an animal
    // therfore a penguin is not a living thing


}
