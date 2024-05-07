package org.example.electradrivebackend.repository.customerrepo;

import org.example.electradrivebackend.model.customermodel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
