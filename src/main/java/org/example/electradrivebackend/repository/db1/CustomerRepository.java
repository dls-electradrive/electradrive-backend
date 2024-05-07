package org.example.electradrivebackend.repository.db1;

import org.example.electradrivebackend.model.m1.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;


public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
