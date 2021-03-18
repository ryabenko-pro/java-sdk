package com.elarian.model;

public final class ChannelMessage {
    public ReceivedMessage received = null;
    public SentMessage sent = null;

    public ChannelMessage(ReceivedMessage received) {
        this.received = received;
    }

    public ChannelMessage(SentMessage sent) {
        this.sent = sent;
    }
}
