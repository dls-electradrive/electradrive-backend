package org.example.electradrivebackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.electradrivebackend.dto.CarResponse;
import org.example.electradrivebackend.model.Car;
import org.example.electradrivebackend.repository.CarRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.EXCHANGE_NAME;
import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.ROUTING_KEY;

@Service
public class CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarService.class);
    private final RabbitTemplate rabbitTemplate;
    private final CarRepository carRepository;
    private final ObjectMapper objectMapper; // Jackson's ObjectMapper

    @Autowired
    public CarService(RabbitTemplate rabbitTemplate, CarRepository carRepository, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.carRepository = carRepository;
        this.objectMapper = objectMapper;
    }

    public void sendCarDetails(Car car) {
        try {
            String carJson = objectMapper.writeValueAsString(car);
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, carJson);
        } catch (JsonProcessingException e) {
            logger.error("Error converting car details to JSON", e);
        }
    }

    public Flux<CarResponse> getAllCars() {
        return Flux.fromIterable(carRepository.findAll())
                .map(car -> new CarResponse(car));
    }

}
