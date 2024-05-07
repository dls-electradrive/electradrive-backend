package org.example.electradrivebackend.model;

import lombok.*;
import org.example.electradrivebackend.dto.SalesDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
@ToString
@Entity
@Table(name = "customer", schema = "electradrive")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    private UUID customerId;
    private String name;
    private String email;
    private String address;
    private String carId;

    public Customer(SalesDto salesDto) {
        this.customerId = salesDto.getCustomerId();
        this.name = salesDto.getCustomerName();
        this.email = salesDto.getCustomerEmail();
        this.address = salesDto.getCustomerAddress();
        this.carId = salesDto.getCarId();
    }
}
