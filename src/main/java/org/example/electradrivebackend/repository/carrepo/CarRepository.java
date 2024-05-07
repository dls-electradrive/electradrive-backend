package org.example.electradrivebackend.repository.carrepo;

import org.example.electradrivebackend.model.carmodel.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID; // Ensure UUID is imported


@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @EntityGraph(attributePaths = {"parts"})
    List<Car> findAll();
}

