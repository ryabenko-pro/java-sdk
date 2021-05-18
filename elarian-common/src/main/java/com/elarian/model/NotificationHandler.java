package com.elarian.model;

import com.elarian.ICustomer;

public interface NotificationHandler<T> extends BaseNotificationHandler<T, Message> {
    default void handle(T notification, ICustomer customer, DataValue appData) {
        handle(notification, customer, appData, null);
    }
}
