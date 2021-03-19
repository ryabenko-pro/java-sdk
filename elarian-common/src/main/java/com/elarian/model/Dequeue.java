package com.elarian.model;

public final class Dequeue implements VoiceAction {
    public MessagingChannel channelNumber;
    public boolean record = false;
    public String queueName;

    public Dequeue(String queueName, MessagingChannel channelNumber) {
        this.queueName = queueName;
        this.channelNumber = channelNumber;
    }
}
