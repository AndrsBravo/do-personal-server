package com.personal.shared.services.entities;

import com.personal.shared.notifications.Notification;

public class ServiceResult {

    private long records;
    private Notification notification;
    private Exception exception;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
