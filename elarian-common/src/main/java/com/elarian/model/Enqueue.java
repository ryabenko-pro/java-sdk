package com.elarian.model;

public final class Enqueue implements VoiceAction {
    public String holdMusic;
    public String queueName;

    public Enqueue(String queueName, String holdMusic) {
        this.queueName = queueName;
        this.holdMusic = holdMusic;
    }
}
