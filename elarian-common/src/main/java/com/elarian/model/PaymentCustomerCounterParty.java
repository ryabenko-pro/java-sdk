package com.elarian.model;

public class PaymentCustomerCounterParty {
    public CustomerNumber customerNumber;
    public PaymentChannel channelNumber;

    public PaymentCustomerCounterParty(CustomerNumber customerNumber, PaymentChannel channelNumber) {
        this.customerNumber = customerNumber;
        this.channelNumber = channelNumber;
    }
}
