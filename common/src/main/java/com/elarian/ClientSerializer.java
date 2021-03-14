package com.elarian;

public interface ClientSerializer<T> {
    public enum ClientSerializerType {
        TEXT, BINARY
    }
    byte[] serialize(T data);
    T deserialize(byte[] data);
}
