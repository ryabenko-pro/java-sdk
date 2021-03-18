package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class SentMessage {
    public String messageId;
    public long createdAt;
    public String sessionId;
    public String inReplyTo;
    public CustomerNumber.Provider provider;
    public String appId;
    public long updatedAt;
    public MessageDeliveryStatus status;
    public List<MessageReactionState> reaction = new ArrayList<>();
    public Message message;
}
