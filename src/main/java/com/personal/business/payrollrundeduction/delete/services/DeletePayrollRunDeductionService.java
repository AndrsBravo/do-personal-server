package com.personal.business.payrollrundeduction.delete.services;

import java.util.Optional;

import com.personal.business.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunDeductionService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunDeductionService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_deductions").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionFail())
                    .get();
        }
        return builder.get();
    }

}
