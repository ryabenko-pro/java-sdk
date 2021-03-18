package com.elarian.model;

public final class CustomerStateUpdateReply {
    public boolean status;
    public String customerId;
    public String description;

    public CustomerStateUpdateReply(boolean status, String customerId, String description) {
        this.status = status;
        this.customerId = customerId;
        this.description = description;
    }
}
