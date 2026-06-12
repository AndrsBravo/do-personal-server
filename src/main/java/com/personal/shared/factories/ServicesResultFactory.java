package com.personal.shared.factories;

import com.personal.shared.notifications.NotificationsFactory;
import com.personal.shared.services.ServiceResult;

public class ServicesResultFactory {

    public static <T> ServiceResult<T> DbNotAvailable() {
        return new ServiceResult<>(NotificationsFactory.DbNotAvailable(), null);
    }
}
