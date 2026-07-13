package com.personal.management.deductionrate.delete.services;

import java.util.Optional;

import com.personal.management.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteDeductionRateService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteDeductionRateService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_deductions_rates").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(DeductionRateNotificationFactory.DeleteDeductionRateSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(DeductionRateNotificationFactory.DeleteDeductionRateFail())
                    .get();
        }
        return builder.get();
    }

}
