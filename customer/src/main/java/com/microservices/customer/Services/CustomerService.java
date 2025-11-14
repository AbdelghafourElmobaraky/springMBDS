package com.microservices.customer.Services;

import com.microservices.customer.Dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(Long id);
}
