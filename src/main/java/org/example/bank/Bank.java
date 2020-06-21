package org.example.bank;

import org.example.bank.domain.Transaction;
import org.example.bank.processing.TransactionSender;
import org.example.bank.validation.TransactionValidator;

public class Bank {

    private final TransactionValidator transactionValidator;
    private final TransactionSender transactionSender;

    public Bank(TransactionValidator transactionValidator, TransactionSender transactionSender) {
        this.transactionValidator = transactionValidator;
        this.transactionSender = transactionSender;
    }

    public void process(Transaction transaction) {
        if (!transactionValidator.validate(transaction)) {
            System.err.println("Could not process transaction " + transaction);
        } else {
            transactionSender.send(transaction);
            System.out.println("Successfully sent transaction " + transaction);
        }
    }

}
