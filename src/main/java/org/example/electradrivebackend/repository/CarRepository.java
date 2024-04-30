package org.example.electradrivebackend.repository;

import org.example.electradrivebackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; // Ensure UUID is imported

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}

