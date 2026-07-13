package com.personal.business.payrollemployee.create.services;

import java.util.Optional;

import com.personal.business.payrollemployee.notifications.PayrollEmployeeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreatePayrollEmployeeService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreatePayrollEmployeeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("payroll_employee").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return ServiceResultBuilder.build()
                    .withRecords(records)
                    .withNotification(PayrollEmployeeNotificationFactory.CreatePayrollEmployeeSuccess())
                    .get();
        } catch (Exception e) {

            return ServiceResultBuilder.build()
                    .withException(e)
                    .withNotification(PayrollEmployeeNotificationFactory.CreatePayrollEmployeeFail())
                    .get();
        }

    }

}
