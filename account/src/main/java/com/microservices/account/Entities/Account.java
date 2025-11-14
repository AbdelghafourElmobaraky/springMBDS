package com.microservices.account.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
@AllArgsConstructor @Builder
public class Account {
    @Id
    private String id;
    private Double balance;
    private LocalDate dateCreated;

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Transient
    private Customer customer;
    private Long customerId;
}