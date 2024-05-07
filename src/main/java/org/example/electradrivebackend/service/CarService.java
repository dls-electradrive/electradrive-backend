package org.example.electradrivebackend.service;

import org.example.electradrivebackend.dto.CarResponse;
import org.example.electradrivebackend.model.carmodel.Car;
import org.example.electradrivebackend.repository.carrepo.CarRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.EXCHANGE_NAME;

@Service
public class CarService {

    private final RabbitTemplate rabbitTemplate;
    private final CarRepository carRepository;

    @Autowired
    public CarService(RabbitTemplate rabbitTemplate, CarRepository carRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.carRepository = carRepository;
    }

    public void sendCarDetails(Car car) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", car);
    }


    public List<CarResponse> getAllCars() {
        System.out.println();
        System.out.println(carRepository.findAll());
        return carRepository.findAll().stream()
                .map(car -> new CarResponse(car))
                .collect(Collectors.toList());
    }
}
