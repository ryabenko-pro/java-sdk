package com.elarian.model;

public enum VoiceCallStatus {
    UNKNOWN(0),
    QUEUED(100),
    ANSWERED(101),
    RINGING(102),
    ACTIVE(200),
    DIALING(201),
    DIAL_COMPLETED(202),
    BRIDGED(203),
    ENQUEUED(204),
    DEQUEUED(205),
    TRANSFERRED(206),
    TRANSFER_COMPLETED(207),
    COMPLETED(300),
    INSUFFICIENT_CREDIT(400),
    NOT_ANSWERED(401),
    INVALID_PHONE_NUMBER(402),
    DESTINATION_NOT_SUPPORTED(403),
    DECOMMISSIONED_CUSTOMER_ID(404),
    EXPIRED(405),
    INVALID_CHANNEL_NUMBER(406),
    APPLICATION_ERROR(501);

    private final int value;

    VoiceCallStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoiceCallStatus valueOf(int value) {
        VoiceCallStatus[] values = VoiceCallStatus.values();
        for (VoiceCallStatus status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }

}
