package com.pfinance.demo.Repositories;

import com.pfinance.demo.Entities.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldSaveNewAccount(){
        //given
        Account newAccount = new Account(new BigDecimal(50.55), "anz plus");

        //when
        Account savedAccount = accountRepository.save(newAccount);

        //then
        assertNotNull(savedAccount.getId());
    }

    @Test
    void shouldRetrieveAllAccounts(){
        //given
        Account newAccount = new Account(new BigDecimal(50.55), "commonwealth");
        Account newAccount2 = new Account(new BigDecimal(50.55), "nab");
        Account newAccount3 = new Account(new BigDecimal(50.55), "medibank");
        Account newAccount4 = new Account(new BigDecimal(50.55), "paypal");
        List<Account> accounts = Arrays.asList(newAccount, newAccount2, newAccount3, newAccount4);
        accountRepository.saveAll(accounts);

        //when
        List<Account> retrievedAccounts = accountRepository.findAll();
        List<String> expectedAccountNames = Arrays.asList("commonwealth", "nab", "medibank", "paypal");
        List<String> retrievedAccountNames = retrievedAccounts.stream()
                .map(Account::getTitle)
                .collect(Collectors.toList());

        //then
        assertEquals(retrievedAccounts.size(), 4);
        assertEquals(expectedAccountNames, retrievedAccountNames);
    }
}