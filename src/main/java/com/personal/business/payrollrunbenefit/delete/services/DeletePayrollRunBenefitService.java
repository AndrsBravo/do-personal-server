package com.personal.business.payrollrunbenefit.delete.services;

import java.util.Optional;

import com.personal.business.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunBenefitService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_benefits").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitFail())
                    .get();
        }
        return builder.get();
    }

}
