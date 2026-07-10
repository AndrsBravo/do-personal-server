package com.personal.business.employeebenefitfeed.create.services;

import java.util.Optional;

import com.personal.business.employeebenefitfeed.notifications.EmployeeBenefitFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeBenefitFeedService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_benefits_feeds").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(EmployeeBenefitFeedNotificationFactory.CreateEmployeeBenefitFeedSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(EmployeeBenefitFeedNotificationFactory.CreateEmployeeBenefitFeedFail())
                    .get();
        }

    }

}
