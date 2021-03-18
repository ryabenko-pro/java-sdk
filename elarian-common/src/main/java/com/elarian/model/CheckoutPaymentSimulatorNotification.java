package com.elarian.model;

public final class CheckoutPaymentSimulatorNotification extends Notification {
    public CustomerNumber customerNumber;
    public PaymentChannel channelNumber;
    public Cash value;
    public String transactionId;
    public PaymentWalletCounterParty wallet = null;
    public PaymentPurseCounterParty purse = null;
}
