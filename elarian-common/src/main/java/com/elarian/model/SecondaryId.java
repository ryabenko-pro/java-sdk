package com.elarian.model;

public final class SecondaryId {
    public String key;
    public String value;

    /**
     *
     * @param key unique secondary id key. Note that this string is not case-sensitive
     * @param value
     */
    public SecondaryId(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

