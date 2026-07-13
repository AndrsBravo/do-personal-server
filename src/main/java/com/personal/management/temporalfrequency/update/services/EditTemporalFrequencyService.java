package com.personal.management.temporalfrequency.update.services;

import java.util.Optional;

import com.personal.management.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditTemporalFrequencyService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("temporal_frequencies").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencySuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(TemporalFrequencyNotificationFactory.UpdateTemporalFrequencyFail())
                    .get();
        }
        return builder.get();
    }

}
