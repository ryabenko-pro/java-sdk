package com.elarian.model;

import java.util.Map;

public final class Activity {
    public String key;
    public Map<String, String> properties;
    public long createdAt;
    public String sessionId;

    public Activity(String key, Map<String, String> properties, String sessionId) {
        this(key, properties, sessionId, System.currentTimeMillis() / 1000);
    }

    public Activity(String key, Map<String, String> properties, String sessionId, long createdAt) {
        this.key = key;
        this.properties = properties;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
    }
}
