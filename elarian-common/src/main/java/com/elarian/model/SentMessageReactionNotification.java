package com.elarian.model;

public final class SentMessageReactionNotification extends Notification {
    public String messageId;
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public MessageReaction reaction;
}
