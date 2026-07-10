package com.personal.business.temporalfrequency.factories;

import com.personal.business.temporalfrequency.filter.services.FilterTemporalFrequencyService;
import com.personal.business.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class TemporalFrequencyServiceFactory {

    private static final String TABLE_NAME = "temporal_frequencies";

    public static CreateService CreateTemporalFrequency(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(TemporalFrequencyNotificationFactory.CreateTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.CreateTemporalFrequencyFail())
                .build();
    }

    public static FilterTemporalFrequencyService FilterTemporalFrequency(String dbClient) {

        return new FilterTemporalFrequencyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditTemporalFrequency(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencyFail())
                .build();
    }

    public static DeleteService DeleteTemporalFrequency(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencySuccess())
                .withFailureNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencyFail())
                .build();
    }

}
