package com.personal.backoffice.commercial.entity.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.entity.notifications.CommercialEntityNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialEntityService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialEntityService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_entities").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(CommercialEntityNotificationFactory.DeleteCommercialEntitySuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(CommercialEntityNotificationFactory.DeleteCommercialEntityFail())
                    .get();
        }
        return builder.get();
    }

}
