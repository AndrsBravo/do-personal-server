package com.personal.business.employeescale.create.services;

import java.util.Optional;

import com.personal.business.employeescale.notifications.EmployeeScaleNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeScaleService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeScaleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employee_scale").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(EmployeeScaleNotificationFactory.CreateEmployeeScaleSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(EmployeeScaleNotificationFactory.CreateEmployeeScaleFail())
                    .get();
        }

    }

}
