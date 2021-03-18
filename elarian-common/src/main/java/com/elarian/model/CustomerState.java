package com.elarian.model;


public final class CustomerState {
    public String customerId;
    public IdentityState identityState;
    public MessagingState messagingState;
    public PaymentState paymentState;
    public ActivityState activityState;

    public CustomerState(String customerId) {
        this.customerId = customerId;
    }
}

