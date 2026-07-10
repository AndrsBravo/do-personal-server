package com.personal.management.deduction.create.services;

import java.util.Optional;

import com.personal.management.deduction.notifications.DeductionNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateDeductionService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_deductions").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(DeductionNotificationFactory.CreateDeductionSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(DeductionNotificationFactory.CreateDeductionFail())
                    .get();
        }
    }

}
