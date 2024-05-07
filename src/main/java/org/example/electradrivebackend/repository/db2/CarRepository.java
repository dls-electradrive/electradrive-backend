package org.example.electradrivebackend.repository.db2;

import org.example.electradrivebackend.model.m2.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID; // Ensure UUID is imported


@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @EntityGraph(attributePaths = {"parts"})
    List<Car> findAll();
}

