package com.elarian.model;

public enum MessagingConsentUpdateStatus {
    UNKNOWN(0),
    QUEUED(100),
    COMPLETED(300),
    INVALID_CHANNEL_NUMBER(401),
    DECOMMISSIONED_CUSTOMER_ID(402),
    APPLICATION_ERROR(501);

    private final int value;

    MessagingConsentUpdateStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MessagingConsentUpdateStatus valueOf(int value) {
        MessagingConsentUpdateStatus[] values = MessagingConsentUpdateStatus.values();
        for (MessagingConsentUpdateStatus status : values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
