package org.example.electradrivebackend.repository;

import org.example.electradrivebackend.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.electradrivebackend.dto.CarResponse;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
