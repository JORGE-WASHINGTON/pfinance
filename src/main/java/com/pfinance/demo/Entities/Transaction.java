package com.pfinance.demo.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


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

    private String description;

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

    protected Transaction() {

    }

    public Transaction(Account account, BigDecimal amount, String merchant, TransactionType type, Category category, LocalDate date, String description) {
        this.account = account;
        this.amount = amount;
        this.merchant = merchant;
        this.type = type;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", account=" + account +
                ", amount=" + amount +
                ", merchant='" + merchant + '\'' +
                ", type=" + type +
                ", category=" + category +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (!id.equals(that.id)) return false;
        if (!account.equals(that.account)) return false;
        if (!amount.equals(that.amount)) return false;
        if (!merchant.equals(that.merchant)) return false;
        if (type != that.type) return false;
        if (category != that.category) return false;
        if (!date.equals(that.date)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + account.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + merchant.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
