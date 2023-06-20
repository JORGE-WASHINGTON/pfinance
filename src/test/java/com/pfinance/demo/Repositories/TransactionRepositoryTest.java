package com.pfinance.demo.Repositories;

import com.pfinance.demo.Entities.Account;
import com.pfinance.demo.Entities.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldCreateTransactionAndFieldsMatch() {
        //given
        Account newAccount = new Account(new BigDecimal(10), "anz");
        Account savedAccount = accountRepository.save(newAccount);
        Transaction newTransaction = new Transaction(savedAccount, new BigDecimal(5), "myki", Transaction.TransactionType.EXPENSE, Transaction.Category.TRANSPORTATION, LocalDate.of(2023, 6, 30), "myki top up");

        //when
        Transaction savedTransaction = transactionRepository.save(newTransaction);

        //then
        assertNotNull(savedTransaction.getId());
        assertEquals(newTransaction.getAccount(), savedTransaction.getAccount());
        assertEquals(newTransaction.getAmount(), savedTransaction.getAmount());
        assertEquals(newTransaction.getDescription(), savedTransaction.getDescription());
        assertEquals(newTransaction.getType(), savedTransaction.getType());
        assertEquals(newTransaction.getCategory(), savedTransaction.getCategory());
        assertEquals(newTransaction.getDate(), savedTransaction.getDate());
    }

    @Test
    void shouldRetrieveAllTransactions() {
        //given
        Account newAccount = new Account(new BigDecimal(10), "anz");
        Account savedAccount = accountRepository.save(newAccount);
        Transaction transaction1 = new Transaction(savedAccount, new BigDecimal(5), "myki", Transaction.TransactionType.EXPENSE, Transaction.Category.TRANSPORTATION, LocalDate.of(2023, 6, 30), "myki top up");
        Transaction transaction2 = new Transaction(savedAccount, new BigDecimal(5), "myki", Transaction.TransactionType.EXPENSE, Transaction.Category.TRANSPORTATION, LocalDate.of(2023, 6, 30), "myki top up");
        Transaction transaction3 = new Transaction(savedAccount, new BigDecimal(5), "myki", Transaction.TransactionType.EXPENSE, Transaction.Category.TRANSPORTATION, LocalDate.of(2023, 6, 30), "myki top up");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);
        transactionRepository.saveAll(transactions);
        //when
        List<Transaction> retrievedTransactions = transactionRepository.findAll();
        //then
        assertEquals(retrievedTransactions.size(), transactions.size());
    }

}