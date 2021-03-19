package com.elarian.model;

public final class Tag {
    public String key;
    public String value;
    public long expiresAt = 0;

    public Tag(String key, String value, long expiresAt) {
        this.key = key;
        this.value = value;
        this.expiresAt = expiresAt;
    }

    public Tag(String key, String value) {
        this.key = key;
        this.value = value;
    }
}