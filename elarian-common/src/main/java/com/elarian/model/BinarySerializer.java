package com.elarian.model;

public final class BinarySerializer implements Serializer<byte[]> {
    @Override
    public byte[] serialize(byte[] data) {
        return data;
    }

    @Override
    public byte[] deserialize(byte[] data) {
        return data;
    }
}
