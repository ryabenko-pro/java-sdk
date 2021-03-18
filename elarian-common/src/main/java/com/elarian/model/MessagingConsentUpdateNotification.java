package com.elarian.model;

public final class MessagingConsentUpdateNotification extends Notification {
    public CustomerNumber customerNumber;
    public MessagingChannel channelNumber;
    public ConsentAction update;
    public Status status;

    public enum Status {
        UNKNOWN(0),
        QUEUED(100),
        COMPLETED(300),
        INVALID_CHANNEL_NUMBER(401),
        DECOMMISSIONED_CUSTOMER_ID(402),
        APPLICATION_ERROR(501);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status valueOf(int value) {
            Status[] values = Status.values();
            for (Status status: values) {
                if (status.value == value) {
                    return status;
                }
            }
            return UNKNOWN;
        }
    }
}
