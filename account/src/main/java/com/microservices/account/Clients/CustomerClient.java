package com.microservices.account.Clients;

import com.microservices.account.Entities.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE", url = "http://localhost:8080")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);  // Retourne Customer entity

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getAllCustomersFallback")
    List<Customer> getAllCustomers();  // Retourne List<Customer> entity

    // Méthodes de fallback
    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");
        return customer;
    }

    default List<Customer> getAllCustomersFallback(Exception exception) {
        return Collections.emptyList();
    }
}