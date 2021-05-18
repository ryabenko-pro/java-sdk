package com.elarian.model;

public final class Reminder {
    public String key;
    public String payload;
    public long remindAt;
    public long interval;

    /**
     *
     * @param key Unique reminder key
     * @param payload Payload associated with the reminder
     * @param remindAt Timestamp in seconds
     */
    public Reminder(String key, String payload, long remindAt) {
        this.key = key;
        this.payload = payload;
        this.remindAt = remindAt;
    }

    /**
     *
     * @param key Unique reminder key
     * @param payload Payload associated with the reminder
     * @param remindAt Timestamp in seconds
     * @param interval Repeat interval in seconds. Must be greater than 60
     */
    public Reminder(String key, String payload, long remindAt, long interval) {
        this.key = key;
        this.payload = payload;
        this.remindAt = remindAt;
        if (interval < 60) {
            throw new RuntimeException("Interval cannot be less than 60");
        }
        this.interval = interval;
    }
}
