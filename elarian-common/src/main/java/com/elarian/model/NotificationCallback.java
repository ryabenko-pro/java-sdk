package com.elarian.model;

public interface NotificationCallback<T> {
    void callback(T message, DataValue appData);
}
