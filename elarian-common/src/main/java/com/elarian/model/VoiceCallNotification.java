package com.elarian.model;

public final class VoiceCallNotification extends Notification {
    public String messageId;
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public String sessionId;
    public VoiceCallInput voice;
}
