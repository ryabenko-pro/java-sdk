package com.elarian.model;

public final class Cash {
    public String currencyCode;
    public double amount;

    public Cash(String currencyCode, double amount) {
        this.currencyCode = currencyCode;
        this.amount = amount;
    }
}
