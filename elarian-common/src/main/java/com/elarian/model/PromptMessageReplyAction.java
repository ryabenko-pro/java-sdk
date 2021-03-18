package com.elarian.model;

public enum PromptMessageReplyAction {
    UNKNOWN(0),
    TEXT(1),
    PHONE_NUMBER(2),
    EMAIL(3),
    LOCATION(4),
    URL(5),
    ;

    private final int value;

    PromptMessageReplyAction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PromptMessageReplyAction valueOf(int value) {
        PromptMessageReplyAction[] values = PromptMessageReplyAction.values();
        for (PromptMessageReplyAction status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
