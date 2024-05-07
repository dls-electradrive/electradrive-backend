package org.example.electradrivebackend.model.m2;

import jakarta.persistence.*;
import lombok.*;
import org.example.electradrivebackend.dto.SalesDto;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cars", schema = "carstorage")
public class Car {

    @Column(name = "car_id")
    @Id
    private String car_id;
    private String Type;
    private String Color;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Part> parts = new HashSet<>();

    public Car(SalesDto salesDto) {
        this.car_id = salesDto.getCarId();
        this.Type = salesDto.getCarType();
        this.Color = salesDto.getCarColor();


        // Convert battery information into a part
        if (salesDto.getCarBattery() != null && !salesDto.getCarBattery().isEmpty()) {
            Part battery = new Part();
            battery.setName("Battery");
            battery.setDescription(salesDto.getCarBattery());
            battery.setCar(this);
            this.parts.add(battery);
        }

        // Convert hitch information into a part
        if (salesDto.isCarHitch()) {
            Part hitch = new Part();
            hitch.setName("Hitch");
            hitch.setDescription("Hitch equipped");
            hitch.setCar(this);
            this.parts.add(hitch);
        }

    }


}

