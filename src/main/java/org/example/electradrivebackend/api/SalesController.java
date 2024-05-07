package org.example.electradrivebackend.api;

import org.example.electradrivebackend.dto.SalesDto;
import org.example.electradrivebackend.model.customermodel.Customer;
import org.example.electradrivebackend.model.carmodel.Car;
import org.example.electradrivebackend.service.CarService;
import org.example.electradrivebackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final CustomerService customerService;
    private final CarService carService;

    @Autowired
    public SalesController(CustomerService customerService, CarService carService) {
        this.customerService = customerService;
        this.carService = carService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> handleFormSubmission(@RequestBody SalesDto salesDto) {
        System.out.println("Trying to save salesobject. Endpoint hit in SalesController.");
        // Create Customer and Car objects from SalesDto and pass them to service layer
        System.out.println(salesDto);
        Customer customer = new Customer(salesDto);
        Car car = new Car(salesDto);

        System.out.println(car.toString());
        System.out.println(customer.toString());
        //carService.sendCarDetails(car);
        customerService.saveCustomer(customer);
        return ResponseEntity.ok("Form data submitted successfully");
    }
}
