package com.elarian.model;

public final class MessagingConsentUpdateNotification extends Notification {
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public ConsentAction update;
    public MessagingConsentUpdateStatus status;
}