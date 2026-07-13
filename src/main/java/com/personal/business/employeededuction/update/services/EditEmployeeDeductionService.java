package com.personal.business.employeededuction.update.services;

import java.util.Optional;

import com.personal.business.employeededuction.notifications.EmployeeDeductionNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditEmployeeDeductionService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditEmployeeDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("employee_deductions").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(EmployeeDeductionNotificationFactory.UpdateEmployeeDeductionSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(EmployeeDeductionNotificationFactory.UpdateEmployeeDeductionFail());

        }
        return builder.get();
    }

}
