package com.pfinance.demo.Repositories;

import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Entities.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldCreateTransaction() {
        //given
        Account newAccount = new Account(new BigDecimal(10), "anz");
        Account savedAccount = accountRepository.save(newAccount);
        Transaction newTransaction = new Transaction(savedAccount, new BigDecimal(5), "myki", Transaction.TransactionType.EXPENSE, Transaction.Category.TRANSPORTATION, LocalDate.of(2023, 6, 30), "myki top up");

        //when
        Transaction savedTransaction = transactionRepository.save(newTransaction);

        //then
        assertNotNull(savedTransaction.getId());
        assertEquals(savedTransaction.getAccount().getId(), savedAccount.getId());
    }

}