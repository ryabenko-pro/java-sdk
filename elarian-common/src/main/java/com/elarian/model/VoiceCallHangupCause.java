package com.elarian.model;

public enum VoiceCallHangupCause {
    UNKNOWN(0),
    UNALLOCATED_NUMBER(1),
    USER_BUSY(17),
    NORMAL_CLEARING(16),
    NO_USER_RESPONSE(18),
    NO_ANSWER(19),
    SUBSCRIBER_ABSENT(20),
    CALL_REJECTED(21),
    NORMAL_UNSPECIFIED(31),
    NORMAL_TEMPORARY_FAILURE(41),
    SERVICE_UNAVAILABLE(63),
    RECOVERY_ON_TIMER_EXPIRE(102),
    ORIGINATOR_CANCEL(487),
    LOSE_RACE(502),
    USER_NOT_REGISTERED(606);

    private final int value;

    VoiceCallHangupCause(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoiceCallHangupCause valueOf(int value) {
        VoiceCallHangupCause[] values = VoiceCallHangupCause.values();
        for (VoiceCallHangupCause status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }

}
