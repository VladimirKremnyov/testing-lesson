package org.example.bank.validation;

import org.example.bank.domain.Transaction;

import java.math.BigDecimal;

public class TransactionValidator {

    private static final BigDecimal MAX_AMOUNT = BigDecimal.valueOf(100);
    private static final BigDecimal MIN_AMOUNT = BigDecimal.valueOf(1);
    private static final BigDecimal MAX_PRICE = BigDecimal.TEN;
    private static final BigDecimal MIN_PRICE = BigDecimal.ZERO;


    public boolean validate(Transaction transaction) {
        if (transaction.getAmount().compareTo(MAX_AMOUNT) > 0 || transaction.getAmount().compareTo(MIN_AMOUNT) < 0) {
            return false;
        }
        return transaction.getPrice().compareTo(MAX_PRICE) <= 0 || transaction.getPrice().compareTo(MIN_PRICE) >= 0;
    }

}
