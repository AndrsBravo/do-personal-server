package com.personal.business.origincategory.delete.services;

import java.util.Optional;

import com.personal.business.origincategory.notifications.OriginCategoryNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteOriginCategoryService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteOriginCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("origin_categories").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(OriginCategoryNotificationFactory.DeleteOriginCategorySuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(OriginCategoryNotificationFactory.DeleteOriginCategoryFail())
                    .get();
        }
        return builder.get();
    }

}
