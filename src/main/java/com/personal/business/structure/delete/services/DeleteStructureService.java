package com.personal.business.structure.delete.services;

import java.util.Optional;

import com.personal.business.structure.notifications.StructureNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteStructureService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_structures").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(StructureNotificationFactory.DeleteStructureSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(StructureNotificationFactory.DeleteStructureFail())
                    .get();
        }
        return builder.get();
    }

}
