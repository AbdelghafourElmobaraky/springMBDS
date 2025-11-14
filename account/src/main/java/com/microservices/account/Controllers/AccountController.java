package com.microservices.account.Controllers;

import com.microservices.account.Dtos.AccountDTO;
import com.microservices.account.Services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping("/account/{id}")
    public AccountDTO getAccountById(@PathVariable String id) {
        return accountService.findById(id);
    }
}