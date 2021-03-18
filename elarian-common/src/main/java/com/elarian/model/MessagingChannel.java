package com.elarian.model;

public final class MessagingChannel {
    public String number;
    public Channel channel;

    public MessagingChannel(String number, Channel channel) {
        this.number = number;
        this.channel = channel;
    }

    public enum Channel {
        UNKNOWN(0),
        SMS(1),
        VOICE(2),
        USSD(3),
        FB_MESSENGER(4),
        TELEGRAM(5),
        WHATSAPP(6),
        EMAIL(7);

        private final int value;

        Channel(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Channel valueOf(int value) {
            Channel[] values = Channel.values();
            for (Channel status: values) {
                if (status.value == value) {
                    return status;
                }
            }
            return UNKNOWN;
        }
    }
}
