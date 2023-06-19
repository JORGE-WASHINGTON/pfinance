package com.pfinance.demo.Controllers;

import com.pfinance.demo.Entities.Transaction;
import com.pfinance.demo.Services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    protected TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(Transaction newTransaction) {
        return transactionService.createTransaction(newTransaction);
    }
}
