package org.example.electradrivebackend.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/car")
public class CarController {


    @GetMapping("/")
    //Return json object with car data
    public String getCarData() {
        return "Car data";
    }
}
