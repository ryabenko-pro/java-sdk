package com.elarian.model;

public enum MessageReaction {
    UNKNOWN(0),
    CLICKED(100),
    UNSUBSCRIBED(200),
    COMPLAINED(201);

    private final int value;

    MessageReaction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MessageReaction valueOf(int value) {
        MessageReaction[] values = MessageReaction.values();
        for (MessageReaction status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
