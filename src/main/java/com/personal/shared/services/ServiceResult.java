package com.personal.shared.services;

import com.personal.shared.notifications.Notification;

public class ServiceResult<T> {

    private final T result;
    private final Notification notification;

    public ServiceResult(Notification notification, T result) {

        this.result = result;
        this.notification = notification;

    }

    public Notification getNotification() {
        return notification;
    }

    public T getResult() {
        return result;
    }

}
