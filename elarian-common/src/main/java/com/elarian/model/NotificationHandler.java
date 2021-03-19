package com.elarian.model;

import com.elarian.ICustomer;

public interface NotificationHandler<T, D> {
    void handle(T notification, ICustomer customer, DataMapValue appData, NotificationCallback<D> callback);
}
