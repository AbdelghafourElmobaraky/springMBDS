package com.microservices.customer.Controllers;

import com.microservices.customer.Dtos.CustomerDTO;
import com.microservices.customer.Services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }
}