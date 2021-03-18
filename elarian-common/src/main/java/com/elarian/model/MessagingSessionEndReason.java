package com.elarian.model;

public enum MessagingSessionEndReason {
    UNKNOWN(0),
    NORMAL_CLEARING(100),
    INACTIVITY(200),
    FAILURE(300);

    private final int value;

    MessagingSessionEndReason(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MessagingSessionEndReason valueOf(int value) {
        MessagingSessionEndReason[] values = MessagingSessionEndReason.values();
        for (MessagingSessionEndReason status : values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
