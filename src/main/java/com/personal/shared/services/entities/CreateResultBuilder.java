package com.personal.shared.services.entities;

import com.personal.shared.notifications.Notification;

public class CreateResultBuilder {

    private CreateResult instance;

    public static CreateResultBuilder build() {

        return new CreateResultBuilder();
    }

    public CreateResultBuilder withNotification(Notification notification) {

        if (this.instance == null) {
            this.instance = new CreateResult();
        }
        this.instance.setNotification(notification);
        return this;
    }

    public CreateResultBuilder withRecords(long records) {
        if (this.instance == null) {
            this.instance = new CreateResult();
        }
        this.instance.setRecords(records);

        return this;
    }

    public CreateResultBuilder withException(Exception exception) {
        if (this.instance == null) {
            this.instance = new CreateResult();
        }
        this.instance.setException(exception);

        return this;
    }

    public CreateResult get() {

        return instance;
    }
}
