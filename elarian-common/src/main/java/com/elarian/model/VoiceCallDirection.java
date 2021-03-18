package com.elarian.model;

public enum VoiceCallDirection {
    UNKNOWN(0),
    INBOUND(1),
    OUTBOUND(2);

    private final int value;

    VoiceCallDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static VoiceCallDirection valueOf(int value) {
        VoiceCallDirection[] values = VoiceCallDirection.values();
        for (VoiceCallDirection status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
