package com.personal.management.temporalfrequency.factories;

import com.personal.business.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.management.temporalfrequency.filter.services.FilterTemporalFrequencyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class TemporalFrequencyServiceFactory {

    private static final String TABLE_NAME = "temporal_frequencies";

    public static CreateService CreateTemporalFrequency() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(TemporalFrequencyNotificationFactory.CreateTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.CreateTemporalFrequencyFail())
                .build();
    }

    public static FilterTemporalFrequencyService FilterTemporalFrequency() {

        return new FilterTemporalFrequencyService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditTemporalFrequency() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencyFail())
                .build();
    }

    public static DeleteService DeleteTemporalFrequency() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencyFail())
                .build();
    }

}
