package com.personal.management.temporalfrequency.delete.services;

import java.util.Optional;

import com.personal.management.temporalfrequency.notifications.TemporalFrequencyNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteTemporalFrequencyService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("temporal_frequencies").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencySuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(TemporalFrequencyNotificationFactory.DeleteTemporalFrequencyFail())
                    .get();
        }
        return builder.get();
    }

}
