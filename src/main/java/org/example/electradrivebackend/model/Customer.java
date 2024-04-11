package org.example.electradrivebackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.electradrivebackend.dto.SalesDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    private UUID customerId;
    private String name;
    private String email;
    private String address;
    private UUID carId;

    public Customer(SalesDto salesDto) {
        this.customerId = salesDto.getCustomerId();
        this.name = salesDto.getCustomerName();
        this.email = salesDto.getCustomerEmail();
        this.address = salesDto.getCustomerAddress();
        this.carId = salesDto.getCarId();
    }
}
