package com.elarian.model;

public interface Serializer<T> {

    enum SerializerType { TEXT, BINARY }

    byte[] serialize(T data);

    T deserialize(byte[] data);
}