package org.example.electradrivebackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class SalesDto {
    private UUID customerId;
    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private UUID carId;
    private String carType;
    private String carColor;
    private String carBattery;
    private boolean carHitch;
    // Constructors, getters, and setters...
}
