package org.example.bank.processing;

import org.example.bank.domain.Transaction;

public class TransactionSender {

    public void send(Transaction transaction) {
        // do nothing
        System.out.println("Simulated transaction processing " + transaction);
    }

}
