package com.microservices.account.Controllers;
import com.microservices.account.Entities.Account;
import com.microservices.account.Repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable String id) {
        return accountRepository.findById(id).orElse(null);
    }
}

