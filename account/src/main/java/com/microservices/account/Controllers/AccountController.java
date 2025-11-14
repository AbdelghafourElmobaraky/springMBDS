package com.microservices.account.Controllers;

import com.microservices.account.Entities.Account;
import com.microservices.account.Repositories.AccountRepository;
import com.microservices.account.Clients.CustomerClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;

    public AccountController(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.customerClient = customerClient;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
            account.setCustomer(customerClient.getCustomerById(account.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable String id) {
        Account accountInstance = accountRepository.findById(id).orElse(null);
        if (accountInstance != null) {
            accountInstance.setCustomer(customerClient.getCustomerById(accountInstance.getCustomerId()));
        }
        return accountInstance;
    }
}