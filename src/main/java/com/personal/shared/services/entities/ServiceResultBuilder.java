package com.personal.shared.services.entities;

import com.personal.shared.notifications.Notification;

public class ServiceResultBuilder<T> {

    private ServiceResult<T> instance;

    public static <T> ServiceResultBuilder<T> build() {

        return new ServiceResultBuilder<>();
    }

    public ServiceResultBuilder<T> withNotification(Notification notification) {

        if (this.instance == null) {
            this.instance = new ServiceResult<>(null);
        }
        this.instance.setNotification(notification);
        return this;
    }

    public ServiceResultBuilder<T> withResult(T result) {
        if (this.instance == null) {
            this.instance = new ServiceResult<>(result);
        }
        this.instance.setResult(result);
        return this;
    }

    public ServiceResultBuilder<T> withRecords(long records) {
        if (this.instance == null) {
            this.instance = new ServiceResult<>(null);
        }
        this.instance.setRecords(records);

        return this;
    }

    public ServiceResultBuilder<T> withException(Exception exception) {
        if (this.instance == null) {
            this.instance = new ServiceResult<>(null);
        }
        this.instance.setException(exception);

        return this;
    }

    public ServiceResult<T> get() {

        return instance;
    }
}
