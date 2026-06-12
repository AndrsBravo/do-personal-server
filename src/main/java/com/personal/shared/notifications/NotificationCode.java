package com.personal.shared.notifications;

public enum NotificationCode {

    AUTHENTICATION_FAIL("authentication_fail"),
    INPUT_VALIDATION_FAIL("input_validation_fail"),
    ENTITY_FAIL("entity_fail"),
    ENTITY_CREATED("entity_created"),
    FETCH_EMPTY("fetch_empty");

    private final String code;

    NotificationCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
