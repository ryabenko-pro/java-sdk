package com.elarian.model;

import java.util.ArrayList;
import java.util.List;

public final class Message {
    public MessageBody body;
    public List<String> labels = new ArrayList<>();
    public String providerTag;
    public ReplyTokenPrompt replyPrompt;

    public Message(MessageBody body) {
        this.body = body;
    }

    public Message(Message msg) {
        this.body = msg.body;
        this.labels = msg.labels;
        this.providerTag = msg.providerTag;
        this.replyPrompt = msg.replyPrompt;
    }
}

