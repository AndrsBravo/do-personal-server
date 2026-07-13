package com.personal.business.payrollrunresult.update.services;

import java.util.Optional;

import com.personal.business.payrollrunresult.notifications.PayrollRunResultNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunResultService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_results").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunResultNotificationFactory.UpdatePayrollRunResultSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunResultNotificationFactory.UpdatePayrollRunResultFail());

        }
        return builder.get();
    }

}
