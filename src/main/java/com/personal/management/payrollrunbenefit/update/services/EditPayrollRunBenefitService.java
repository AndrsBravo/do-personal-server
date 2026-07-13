package com.personal.management.payrollrunbenefit.update.services;

import java.util.Optional;

import com.personal.management.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditPayrollRunBenefitService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditPayrollRunBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("payroll_runs_benefits").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitFail());

        }
        return builder.get();
    }

}
