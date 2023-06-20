package com.pfinance.demo.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal balance;
    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account( BigDecimal balance, String title) {
        this.balance = balance;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (!Objects.equals(id, account.id)) return false;
        if (!Objects.equals(balance, account.balance)) return false;
        if (!Objects.equals(title, account.title)) return false;
        return Objects.equals(transactions, account.transactions);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", title='" + title + '\'' +
                ", transactions=" + transactions +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    protected Account() {}

    public Integer getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getTitle() {
        return title;
    }

}
