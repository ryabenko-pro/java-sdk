package com.elarian.hera.android;

public interface ClientSerializer<T> {
    byte[] serialize(T data);
    T deserialize(byte[] data);
}
