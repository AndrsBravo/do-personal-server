package com.personal.business.employeededuction.delete.services;

import java.util.Optional;

import com.personal.business.employeededuction.notifications.EmployeeDeductionNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeDeductionService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_deductions").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(EmployeeDeductionNotificationFactory.DeleteEmployeeDeductionSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(EmployeeDeductionNotificationFactory.DeleteEmployeeDeductionFail())
                    .get();
        }
        return builder.get();
    }

}
