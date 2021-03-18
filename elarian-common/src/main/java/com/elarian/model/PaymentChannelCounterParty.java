package com.elarian.model;

public class PaymentChannelCounterParty {
    public PaymentChannel channelNumber;
    public int networkCode;
    public String account;

    public PaymentChannelCounterParty(PaymentChannel channelNumber, String account, int networkCode) {
        this.channelNumber = channelNumber;
        this.account = account;
        this.networkCode = networkCode;
    }
}
