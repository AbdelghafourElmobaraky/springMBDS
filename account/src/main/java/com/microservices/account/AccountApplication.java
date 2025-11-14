package com.microservices.account;

import com.microservices.account.Clients.CustomerClient;
import com.microservices.account.Entities.Account;
import com.microservices.account.Entities.CurrencyType;
import com.microservices.account.Repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerClient customerClient) {
        return args -> {
            customerClient.getAllCustomers().forEach(customer -> {
                Account accountInstance = Account.builder()
                        .customerId(customer.getId())
                        .id(UUID.randomUUID().toString())
                        .balance(Math.random()*1000)
                        .dateCreated(LocalDate.now())
                        .currency(CurrencyType.EUR)
                        .build();
                accountRepository.save(accountInstance);
            });
        };
    }
}