package com.elarian.model;

import com.elarian.ICustomer;

public interface NotificationHandler<T, D, S> {
    void handle(T notification, ICustomer customer, S appData, NotificationCallback<D, S> callback);
}
