package org.example.electradrivebackend.repository.db2;

import org.example.electradrivebackend.model.m2.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; // Ensure UUID is imported

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}

