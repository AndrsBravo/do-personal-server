package com.personal.business.payrollruntype.update.services;

import java.util.Optional;

import com.personal.business.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunTypeService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_types").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeFail());

        }
        return builder.get();
    }

}
