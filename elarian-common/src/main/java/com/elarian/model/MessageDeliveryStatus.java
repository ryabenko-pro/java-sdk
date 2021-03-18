package com.elarian.model;

public enum MessageDeliveryStatus {
    UNKNOWN(0),
    QUEUED(100),
    SENT(101),
    DELIVERED(300),
    READ(301),
    RECEIVED(302),
    SESSION_INITIATED(303),
    FAILED(400),
    NO_CONSENT(401),
    NO_CAPABILITY(402),
    EXPIRED(403),
    NO_SESSION_IN_PROGRESS(404),
    OTHER_SESSION_IN_PROGRESS(405),
    INVALID_REPLY_TOKEN(406),
    INVALID_CHANNEL_NUMBER(407),
    NOT_SUPPORTED(408),
    INVALID_REPLY_TO_MESSAGE_ID(409),
    INVALID_CUSTOMER_ID(410),
    DUPLICATE_REQUEST(411),
    TAG_NOT_FOUND(412),
    CUSTOMER_NUMBER_NOT_FOUND(413),
    DECOMMISSIONED_CUSTOMER_ID(414),
    REJECTED(415),
    INVALID_REQUEST(416),
    APPLICATION_ERROR(501);

    private final int value;

    MessageDeliveryStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MessageDeliveryStatus valueOf(int value) {
        MessageDeliveryStatus[] values = MessageDeliveryStatus.values();
        for (MessageDeliveryStatus status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
