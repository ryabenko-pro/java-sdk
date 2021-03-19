package com.elarian.model;

public final class MessageReply {
    public MessageDeliveryStatus status;
    public String messageId;
    public String sessionId;
    public String customerId;
    public String description;


    public MessageReply(String messageId, String sessionId, String customerId, MessageDeliveryStatus status, String description) {
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.customerId = customerId;
        this.status = status;
        this.description = description;
    }
}