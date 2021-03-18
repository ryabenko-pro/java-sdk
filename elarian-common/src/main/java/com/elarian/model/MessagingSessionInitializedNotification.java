package com.elarian.model;

public final class MessagingSessionInitializedNotification extends Notification {
    public String sessionId;
    public long expiresAt;
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
}
