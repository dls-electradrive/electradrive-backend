package org.example.electradrivebackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.electradrivebackend.dto.SalesDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    private UUID carId;
    private String type;
    private String color;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Part> parts = new HashSet<>();

    public Car(SalesDto salesDto) {
        this.carId = salesDto.getCarId();
        this.type = salesDto.getCarType();
        this.color = salesDto.getCarColor();

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

