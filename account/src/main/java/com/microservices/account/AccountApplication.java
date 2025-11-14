package com.microservices.account;

import com.microservices.account.Entities.Account;
import com.microservices.account.Entities.CurrencyType;
import com.microservices.account.Repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {
            List<Account> accountList = List.of(
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(180D)
                            .currency(CurrencyType.EUR)
                            .dateCreated(LocalDate.now())
                            .customerId(1L)
                            .build(),
                    Account.builder()
                            .id(UUID.randomUUID().toString())
                            .balance(280D)
                            .currency(CurrencyType.EUR)
                            .dateCreated(LocalDate.now())
                            .customerId(2L)
                            .build()
            );
            accountRepository.saveAll(accountList);
        };
    }
}