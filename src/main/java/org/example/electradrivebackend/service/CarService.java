package org.example.electradrivebackend.service;

import org.example.electradrivebackend.model.Car;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.EXCHANGE_NAME;
import static org.example.electradrivebackend.configuration.RabbitMQConfiguration.ROUTING_KEY;

@Service
public class CarService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public CarService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendCarDetails(Car car) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, car);
    }
}
