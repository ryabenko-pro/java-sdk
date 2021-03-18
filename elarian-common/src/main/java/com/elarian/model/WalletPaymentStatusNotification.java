package com.elarian.model;

public final class WalletPaymentStatusNotification extends Notification {
    public String walletId;
    public String transactionId;
    public PaymentStatus status;
}

