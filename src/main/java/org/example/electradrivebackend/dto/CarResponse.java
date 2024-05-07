package org.example.electradrivebackend.dto;

import lombok.*;
import org.example.electradrivebackend.model.m2.Car;
import org.example.electradrivebackend.model.m2.Part;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarResponse {

    private String Id;
    private String type;
    private String color;
    private String battery;
    private boolean hitch;

    public CarResponse(Car car) {
        this.Id = car.getCar_id();
        this.type = car.getType();
        this.color = car.getColor();

        this.battery = car.getParts().stream()
                .filter(part -> "Battery".equals(part.getName()))
                .findFirst()
                .map(Part::getDescription)
                .orElse(null);
        this.hitch = car.getParts().stream()
                .anyMatch(part -> "Hitch".equals(part.getName()));

    }


}
