package com.elarian.hera;

public interface ClientSerializer<T> {
    byte[] serialize(T data);
    T deserialize(byte[] data);
}
