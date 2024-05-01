package org.example.electradrivebackend.service;

import org.example.electradrivebackend.dto.CarResponse;
import org.example.electradrivebackend.model.Car;
import org.example.electradrivebackend.repository.CarRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.EXCHANGE_NAME;
import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.ROUTING_KEY;

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
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, car);
    }

    public Flux<CarResponse> getAllCars() {
        return Flux.fromIterable(carRepository.findAll())
                .map(car -> new CarResponse(car));
    }
}
