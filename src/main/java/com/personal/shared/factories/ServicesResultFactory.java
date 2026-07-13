package com.personal.shared.factories;

import com.personal.shared.notifications.NotificationsFactory;
import com.personal.shared.services.entities.ServiceResultBuilder;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.FetchResult;
import com.personal.shared.services.entities.FetchResultBuilder;

public class ServicesResultFactory {

    public static <T> FetchResult<T> DbNotAvailable() {
        return FetchResultBuilder.<T>build().withNotification(NotificationsFactory.DbNotAvailable()).get();
    }

    public static ServiceResult NotAvailable() {
        return ServiceResultBuilder.build().withNotification(NotificationsFactory.DbNotAvailable()).get();
    }
}
