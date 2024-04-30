package org.example.electradrivebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.electradrivebackend.dto.SalesDto;

import java.util.UUID;
@ToString
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {


    @Id
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
