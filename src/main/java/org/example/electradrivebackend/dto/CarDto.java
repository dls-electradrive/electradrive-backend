package org.example.electradrivebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private int id;
    private String name;
    private String emailadress;
    private String adress;
    private String cartype;
    private String carcolor;
    private String carbattery;
    private boolean trailerhitch;
    private boolean frominventory;
}

