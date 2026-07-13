package com.personal.management.payrollrundeduction.update.services;

import java.util.Optional;

import com.personal.management.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunDeductionService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_deductions").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionFail());

        }
        return builder.get();
    }

}
