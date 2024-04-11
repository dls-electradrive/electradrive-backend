package org.example.electradrivebackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.electradrivebackend.dto.SalesDto;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Car {

    private UUID carId;
    private String type;
    private String color;
    private String battery;
    private boolean hitch;

    public Car(SalesDto salesDto) {
        this.carId = salesDto.getCarId();
        this.type = salesDto.getCarType();
        this.color = salesDto.getCarColor();
        this.battery = salesDto.getCarBattery();
        this.hitch = salesDto.isCarHitch();
    }
}
