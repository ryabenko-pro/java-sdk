package com.elarian.model;

import com.elarian.ICustomer;

public interface BaseNotificationHandler<T, D> {
    void handle(T notification, ICustomer customer, DataValue appData, NotificationCallback<D> responder);
}

