package com.personal.business.financecategory.update.services;

import java.util.Optional;

import com.personal.business.financecategory.notifications.FinanceCategoryNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditFinanceCategoryService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditFinanceCategoryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("finance_categories").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategorySuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategoryFail());

        }
        return builder.get();
    }

}
