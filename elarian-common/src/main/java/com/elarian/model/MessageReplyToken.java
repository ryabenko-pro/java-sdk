package com.elarian.model;

public final class MessageReplyToken {
    public String token;
    public long expiresAt;

    public MessageReplyToken(String token, long expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }
}
