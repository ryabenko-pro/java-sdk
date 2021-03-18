package com.elarian.model;

public class PaymentWalletCounterParty {
    public String customerId;
    public String walletId;

    public PaymentWalletCounterParty(String customerId, String walletId) {
        this.customerId = customerId;
        this.walletId = walletId;
    }
}
