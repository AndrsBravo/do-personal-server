package com.personal.backoffice.commercial.plandetail.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plandetail.notifications.CommercialPlanDetailNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialPlanDetailService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_plan_details").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(CommercialPlanDetailNotificationFactory.DeleteCommercialPlanDetailSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(CommercialPlanDetailNotificationFactory.DeleteCommercialPlanDetailFail())
                    .get();
        }
        return builder.get();
    }

}
