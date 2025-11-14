package com.microservices.account.Mappers;

import com.microservices.account.Dtos.AccountDTO;
import com.microservices.account.Entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public AccountDTO toDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getBalance(),
                account.getDateCreated(),
                account.getCurrency(),
                account.getCustomer(),  // Le customer entity (pas DTO) comme dans le TP
                account.getCustomerId()
        );
    }

    public Account toAccount(AccountDTO accountDTO) {
        if (accountDTO != null) {
            return Account.builder()
                    .id(accountDTO.getId())
                    .balance(accountDTO.getBalance())
                    .dateCreated(accountDTO.getDateCreated())
                    .currency(accountDTO.getCurrency())
                    .customer(accountDTO.getCustomer())  // Customer entity direct
                    .customerId(accountDTO.getCustomerId())
                    .build();
        }
        return null;
    }
}