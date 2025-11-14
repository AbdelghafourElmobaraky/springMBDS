package com.microservices.account.Services;

import com.microservices.account.Dtos.AccountDTO;
import com.microservices.account.Entities.Account;
import com.microservices.account.Entities.Customer;
import com.microservices.account.Mappers.AccountMapper;
import com.microservices.account.Repositories.AccountRepository;
import com.microservices.account.Clients.CustomerClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final CustomerClient customerClient;

    public AccountServiceImpl(AccountRepository accountRepository,
                              AccountMapper accountMapper,
                              CustomerClient customerClient) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.customerClient = customerClient;
    }

    @Override
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream()
                .map(account -> {
                    AccountDTO accountDTO = accountMapper.toDTO(account);
                    Customer customer = customerClient.getCustomerById(account.getCustomerId());
                    accountDTO.setCustomer(customer);
                    return accountDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO findById(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            AccountDTO accountDTO = accountMapper.toDTO(account);
            Customer customer = customerClient.getCustomerById(account.getCustomerId());
            accountDTO.setCustomer(customer);
            return accountDTO;
        }
        return null;
    }
}