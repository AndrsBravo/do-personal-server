package com.personal.business.employee.create.services;

import java.util.Optional;

import com.personal.business.employee.notifications.EmployeeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateEmployeeService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("employees").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(EmployeeNotificationFactory.CreateEmployeeSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(EmployeeNotificationFactory.CreateEmployeeFail())
                    .get();
        }

    }

}
