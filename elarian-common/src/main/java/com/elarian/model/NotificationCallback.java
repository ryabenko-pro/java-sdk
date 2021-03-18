package com.elarian.model;

import java.util.HashMap;

public interface NotificationCallback<T, S> {
    void callback(T message, S appData);
}
