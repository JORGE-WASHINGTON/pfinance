package com.pfinance.demo.Controllers;

import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Repositories.AccountRepository;
import com.pfinance.demo.Services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;


    public AccountController(AccountRepository accountRepository, AccountService accountService){
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/accounts")
    Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);
    }

    @DeleteMapping("/accounts/{id}")
    void deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccount(id);
    }


}
