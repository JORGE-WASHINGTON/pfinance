package com.pfinance.demo.Services;

import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    protected AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account newAccount) {
        return accountRepository.save(newAccount);
    }
}
