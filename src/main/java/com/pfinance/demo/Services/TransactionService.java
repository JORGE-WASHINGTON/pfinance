package com.pfinance.demo.Services;

import com.pfinance.demo.Entities.Transaction;
import com.pfinance.demo.Repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    protected TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction newTransaction){
        return transactionRepository.save(newTransaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }
}
