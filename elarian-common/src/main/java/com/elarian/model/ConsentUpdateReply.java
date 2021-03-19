package com.elarian.model;

public final class ConsentUpdateReply {
    public MessagingConsentUpdateStatus status;
    public String description;
    public String customerId;

    public ConsentUpdateReply(MessagingConsentUpdateStatus status, String description, String customerId) {
        this.status = status;
        this.description = description;
        this.customerId = customerId;
    }
}
