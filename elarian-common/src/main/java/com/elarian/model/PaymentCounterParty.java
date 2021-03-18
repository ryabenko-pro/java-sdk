package com.elarian.model;

public class PaymentCounterParty {
    public PaymentCustomerCounterParty customer = null;
    public PaymentPurseCounterParty purse = null;
    public PaymentWalletCounterParty wallet = null;
    public PaymentChannelCounterParty channel = null;

    public PaymentCounterParty(PaymentCustomerCounterParty customer) {
        this.customer = customer;
    }

    public PaymentCounterParty(PaymentPurseCounterParty purse) {
        this.purse = purse;
    }

    public PaymentCounterParty(PaymentWalletCounterParty wallet) {
        this.wallet = wallet;
    }

    public PaymentCounterParty(PaymentChannelCounterParty channel) {
        this.channel = channel;
    }
}
