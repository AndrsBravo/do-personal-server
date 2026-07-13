package com.personal.shared.services.entities;

import com.personal.shared.notifications.Notification;
import com.personal.shared.notifications.NotificationsFactory;

public abstract class ResultBuilder<T extends ServiceResult> {

    protected final T instance;

    public ResultBuilder(T instance) {
        this.instance = instance;
    }

    public ResultBuilder<T> withNotification(Notification notification) {

        this.instance.setNotification(notification);
        return this;
    }

    public ResultBuilder<T> withRecords(long records) {
        this.instance.setRecords(records);

        return this;
    }

    public ResultBuilder<T> withException(Exception exception) {
        this.instance.setException(exception);

        return this;
    }

    public T NotAvailable() {
        this.instance.setNotification(NotificationsFactory.DbNotAvailable());
        return instance;
    }

    public T get() {

        return instance;
    }
}
