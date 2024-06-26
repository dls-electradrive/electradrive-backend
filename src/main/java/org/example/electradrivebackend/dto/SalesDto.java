package org.example.electradrivebackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@ToString
@Getter @Setter
public class SalesDto {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private String carId;
    private String carType;
    private String carColor;
    private String carBattery;
    private boolean carHitch;
    // Constructors, getters, and setters...
}
