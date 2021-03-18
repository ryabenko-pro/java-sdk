package com.elarian.model;

public final class MessagingSessionEndedNotification extends Notification {
    public String sessionId;
    public long duration;
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public Reason reason;

    public enum Reason {
        UNKNOWN(0),
        NORMAL_CLEARING(100),
        INACTIVITY(200),
        FAILURE(300);

        private final int value;

        Reason(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Reason valueOf(int value) {
            Reason[] values = Reason.values();
            for (Reason status: values) {
                if (status.value == value) {
                    return status;
                }
            }
            return UNKNOWN;
        }
    }
}
