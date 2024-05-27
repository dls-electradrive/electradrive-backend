package org.example.electradrivebackend.service;

import org.example.electradrivebackend.model.customermodel.Customer;
import org.example.electradrivebackend.model.customermodel.IdempotencyKey;
import org.example.electradrivebackend.repository.customerrepo.CustomerRepository;
import org.example.electradrivebackend.repository.customerrepo.IdempotencyKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final IdempotencyKeyRepository idempotencyKeyRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, IdempotencyKeyRepository idempotencyKeyRepository) {
        this.customerRepository = customerRepository;
        this.idempotencyKeyRepository = idempotencyKeyRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public boolean isDuplicateRequest(String key) {
        boolean isDuplicate = idempotencyKeyRepository.existsById(key);
        if (isDuplicate) {
            System.out.println("Duplicate request detected for key: " + key);
        }
        return isDuplicate;
    }

    public void saveIdempotencyKey(String key) {
        idempotencyKeyRepository.save(new IdempotencyKey(key, LocalDateTime.now()));
    }
}
