package com.elarian.model;

public final class SendCustomerPaymentSimulatorNotification extends Notification {
    public CustomerNumber customerNumber;
    public PaymentChannel channelNumber;
    public Cash value;
    public PaymentWalletCounterParty wallet = null;
    public PaymentPurseCounterParty purse = null;
    public String transactionId;
}
