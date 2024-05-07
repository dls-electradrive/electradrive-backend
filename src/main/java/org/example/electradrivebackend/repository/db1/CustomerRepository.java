package org.example.electradrivebackend.repository.db1;

import org.example.electradrivebackend.model.m1.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
