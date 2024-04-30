package org.example.electradrivebackend.dto;

import lombok.*;
import org.example.electradrivebackend.model.Car;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarResponse {

    private UUID carId;
    private String type;
    private String color;
    private String battery;
    private boolean hitch;


    public CarResponse(Car car) {
        this.carId = car.getCarId();
        this.type = car.getType();
        this.color = car.getColor();
        this.battery = car.getBattery();
        this.hitch = car.isHitch();
    }
}