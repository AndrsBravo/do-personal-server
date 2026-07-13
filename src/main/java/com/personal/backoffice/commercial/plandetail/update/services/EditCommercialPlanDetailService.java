package com.personal.backoffice.commercial.plandetail.update.services;

import java.util.Optional;

import com.personal.backoffice.commercial.plandetail.notifications.CommercialPlanDetailNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditCommercialPlanDetailService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditCommercialPlanDetailService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("commercial_plan_details").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(CommercialPlanDetailNotificationFactory.UpdateCommercialPlanDetailSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(CommercialPlanDetailNotificationFactory.UpdateCommercialPlanDetailFail());

        }
        return builder.get();
    }

}
