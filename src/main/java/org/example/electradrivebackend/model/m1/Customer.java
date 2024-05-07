package org.example.electradrivebackend.model.m1;

import jakarta.persistence.Column;
import lombok.*;
import org.example.electradrivebackend.dto.SalesDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
@ToString
@Entity
@Table(name = "customers", schema = "electradrive")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Column(name = "customer_id")
    @Id
    private String customer_Id;
    private String name;
    private String email;
    private String address;
    private String car_Id;

    public Customer(SalesDto salesDto) {
        this.customer_Id = salesDto.getCustomerId();
        this.name = salesDto.getCustomerName();
        this.email = salesDto.getCustomerEmail();
        this.address = salesDto.getCustomerAddress();
        this.car_Id = salesDto.getCarId();
    }
}
