package com.pfinance.demo.Entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String merchant;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Category category;

    @Column(nullable = false)
    private LocalDate date;


    public enum TransactionType {
        EXPENSE,
        INCOME
    }

    public enum Category {
        HOME,
        ENTERTAINMENT,
        EDUCATION,
        EATING_OUT,
        GROCERIES,
        RENT,
        TRANSPORTATION,
        PAYCHECK
    }


}
