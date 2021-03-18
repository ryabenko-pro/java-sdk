package com.elarian.model;

public final class TextSerializer implements Serializer<String> {
    @Override
    public byte[] serialize(String data) {
        return data.getBytes();
    }

    @Override
    public String deserialize(byte[] data) {
        return new String(data);
    }
}

