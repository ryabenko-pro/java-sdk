package com.elarian.model;

public final class Dequeue implements VoiceAction {
    public MessagingChannel channelNumber;
    public boolean record;
    public String queueName;

    public Dequeue(String queueName, MessagingChannel channelNumber, boolean record) {
        this.queueName = queueName;
        this.channelNumber = channelNumber;
        this.record = record;
    }
}
