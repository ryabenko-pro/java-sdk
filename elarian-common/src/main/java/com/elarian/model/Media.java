package com.elarian.model;

public final class Media {
    public String url;
    public MediaType type;

    public Media(String url, MediaType type) {
        this.url = url;
        this.type = type;
    }

    public enum MediaType {
        UNKNOWN(0),
        IMAGE(1),
        AUDIO(2),
        VIDEO(3),
        DOCUMENT(4),
        VOICE(5),
        STICKER(6),
        CONTACT(7);

        private final int value;

        MediaType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MediaType valueOf(int value) {
            MediaType[] values = MediaType.values();
            for (MediaType status: values) {
                if (status.value == value) {
                    return status;
                }
            }
            return UNKNOWN;
        }
    }
}
