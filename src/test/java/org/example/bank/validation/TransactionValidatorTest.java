package org.example.bank.validation;

import org.example.bank.domain.CurrencyPair;
import org.example.bank.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class TransactionValidatorTest {

    private static final BigDecimal MAX_AMOUNT = BigDecimal.valueOf(100);
    private static final BigDecimal MIN_AMOUNT = BigDecimal.valueOf(1);
    private static final BigDecimal MAX_PRICE = BigDecimal.TEN;
    private static final BigDecimal MIN_PRICE = BigDecimal.ZERO;
    private static final BigDecimal LOWER_THEN_MIN_AMOUN = BigDecimal.valueOf(0);
    public static final CurrencyPair NO_CURRENCY_PAIR = null;
    public static final BigDecimal EMPTY_PRICE = null;
    public static final int FROM_ACCOUNT_NUMBER = 0;
    public static final int TO_ACCOUNT_NUMBER = 1;

    @Mock
    private TransactionValidator transactionValidator;

    @Test
    public void shouldNotPassValidationWhenLowerLimitCrossed() {
        Transaction transaction = new Transaction(LOWER_THEN_MIN_AMOUN, NO_CURRENCY_PAIR, EMPTY_PRICE, FROM_ACCOUNT_NUMBER, TO_ACCOUNT_NUMBER);
        boolean validationResult = transactionValidator.validate(transaction);
        assertFalse(validationResult);
    }
}
