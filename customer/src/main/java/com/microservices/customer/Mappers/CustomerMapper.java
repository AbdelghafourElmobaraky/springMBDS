package com.microservices.customer.Mappers;

import com.microservices.customer.Dtos.CustomerDTO;
import com.microservices.customer.Entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer)
    {
        return new CustomerDTO(customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail());
    }
    public Customer toCustomer(CustomerDTO customerDTO)
    {
        if (customerDTO != null)
            return new Customer(null, customerDTO.getFirstName(),
                    customerDTO.getLastName(), customerDTO.getEmail());
        return null;
    }
}
