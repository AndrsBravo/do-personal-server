package com.personal.shared.notifications;

public enum NotificationsType {

    INFO("info"),
    ERROR("error"),
    WARNING("info"),
    SUCCESS("success");

    private final String type;

    NotificationsType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
