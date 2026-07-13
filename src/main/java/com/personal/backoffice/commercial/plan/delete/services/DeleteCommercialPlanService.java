package com.personal.backoffice.commercial.plan.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plan.notifications.CommercialPlanNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialPlanService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialPlanService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_plan").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(CommercialPlanNotificationFactory.DeleteCommercialPlanSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(CommercialPlanNotificationFactory.DeleteCommercialPlanFail())
                    .get();
        }
        return builder.get();
    }

}
