package com.elarian.model;

public enum TextToSpeechVoice {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2);

    private final int value;

    TextToSpeechVoice(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TextToSpeechVoice valueOf(int value) {
        TextToSpeechVoice[] values = TextToSpeechVoice.values();
        for (TextToSpeechVoice status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
