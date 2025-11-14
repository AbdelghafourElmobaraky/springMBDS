package com.microservices.customer.Controllers;

import com.microservices.customer.Entities.Customer;
import com.microservices.customer.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
