package com.elarian.model;

public final class SendChannelPaymentSimulatorNotification extends Notification {
    public PaymentChannel channelNumber;
    public Cash value;
    public String account;
    public String transactionId;
    public PaymentWalletCounterParty wallet = null;
    public PaymentPurseCounterParty purse = null;
}

