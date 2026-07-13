package com.personal.management.deductionrate.update.services;

import java.util.Optional;

import com.personal.management.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditDeductionRateService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_deductions_rates").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(DeductionRateNotificationFactory.UpdateDeductionRateSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(DeductionRateNotificationFactory.UpdateDeductionRateFail());

        }
        return builder.get();
    }

}
