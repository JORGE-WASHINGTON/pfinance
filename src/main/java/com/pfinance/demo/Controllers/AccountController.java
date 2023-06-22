package com.pfinance.demo.Controllers;

import com.pfinance.demo.DTO.CreateAccountRequestDTO;
import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Repositories.AccountRepository;
import com.pfinance.demo.Services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{userId}/accounts")
    List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/{userId}/accounts")
    ResponseEntity<Account> createAccount(@PathVariable Long userId, @RequestBody @Valid CreateAccountRequestDTO createAccountRequestDTO) {
        Account createdAccount = accountService.createAccount(userId, createAccountRequestDTO);
        return ResponseEntity.ok().body(createdAccount);
    }



}
