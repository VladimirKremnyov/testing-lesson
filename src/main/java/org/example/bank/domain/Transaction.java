package org.example.bank.domain;

import java.math.BigDecimal;

public class Transaction {
    private final BigDecimal amount;
    private final CurrencyPair currencyPair;
    private final BigDecimal price;
    private final int fromAccountNumber;
    private final int toAccountNumber;

    public Transaction(BigDecimal amount, CurrencyPair currencyPair, BigDecimal price, int fromAccountNumber, int toAccountNumber) {
        this.amount = amount;
        this.currencyPair = currencyPair;
        this.price = price;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getFromAccountNumber() {
        return fromAccountNumber;
    }

    public int getToAccountNumber() {
        return toAccountNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", currencyPair=" + currencyPair +
                ", price=" + price +
                ", fromAccountNumber=" + fromAccountNumber +
                ", toAccountNumber=" + toAccountNumber +
                '}';
    }
}
