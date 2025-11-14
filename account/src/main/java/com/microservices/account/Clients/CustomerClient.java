package com.microservices.account.Clients;

import com.microservices.account.Entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service", url = "http://localhost:8080")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    List<Customer> getAllCustomers();
}
