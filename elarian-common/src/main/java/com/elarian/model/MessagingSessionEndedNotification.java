package com.elarian.model;

public final class MessagingSessionEndedNotification extends Notification {
    public String sessionId;
    public long duration;
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public MessagingSessionEndReason reason;
}