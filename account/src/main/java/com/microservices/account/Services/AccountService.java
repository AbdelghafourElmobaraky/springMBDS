package com.microservices.account.Services;

import com.microservices.account.Dtos.AccountDTO;
import java.util.List;

public interface AccountService {
    List<AccountDTO> findAll();
    AccountDTO findById(String id);
}