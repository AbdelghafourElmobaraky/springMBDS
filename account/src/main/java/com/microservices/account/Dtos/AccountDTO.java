package com.microservices.account.Dtos;

import com.microservices.account.Entities.CurrencyType;
import com.microservices.account.Entities.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    private CurrencyType currency;
    private Customer customer;  // Entity Customer directe (comme dans le TP)
    private Long customerId;
}