package com.elarian.model;

public final class Tag {
    public String key;
    public String value;
    public long expiresAt;

    /**
     *
     * @param key Unique tag key. Note that this string is not case-sensitive
     * @param value
     * @param expiresAt
     */
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