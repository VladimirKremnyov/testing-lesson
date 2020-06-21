package org.example.bank.domain;

public class CurrencyPair {
    private final String baseCurrency;
    private final String termCurrency;

    private CurrencyPair(String baseCurrency, String termCurrency) {
        this.baseCurrency = baseCurrency;
        this.termCurrency = termCurrency;
    }

    public static CurrencyPair of(String baseCurrency, String termCurrency) {
        return new CurrencyPair(baseCurrency, termCurrency);
    }
}
