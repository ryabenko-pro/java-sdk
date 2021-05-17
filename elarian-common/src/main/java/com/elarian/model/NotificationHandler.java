package com.elarian.model;

import com.elarian.ICustomer;

public interface NotificationHandler<T, D> {
    void handle(T notification, ICustomer customer, DataValue appData, NotificationCallback<D> responder);
}
