package com.pfinance.demo.Controllers;

import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Repositories.AccountRepository;
import com.pfinance.demo.Services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;


    public AccountController(AccountRepository accountRepository, AccountService accountService){
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);
    }


}
