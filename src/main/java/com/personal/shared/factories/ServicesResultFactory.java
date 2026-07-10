package com.personal.shared.factories;

import com.personal.shared.notifications.NotificationsFactory;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.ServiceResult;

public class ServicesResultFactory {

    public static <T> ServiceResult<T> DbNotAvailable() {
        return new ServiceResult<>(NotificationsFactory.DbNotAvailable(), null);
    }

    public static CreateResult NotAvailable() {
        return new CreateResult(NotificationsFactory.DbNotAvailable());
    }
}
