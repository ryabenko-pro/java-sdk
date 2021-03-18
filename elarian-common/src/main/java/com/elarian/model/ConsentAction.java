package com.elarian.model;

public enum ConsentAction {
    UNKNOWN(0),
    ALLOW(1),
    BLOCK(2);

    private final int value;

    ConsentAction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ConsentAction valueOf(int value) {
        ConsentAction[] values = ConsentAction.values();
        for (ConsentAction status: values) {
            if (status.value == value) {
                return status;
            }
        }
        return UNKNOWN;
    }
}
