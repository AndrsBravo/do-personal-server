package com.personal.business.payrollcalculation.delete.services;

import java.util.Optional;

import com.personal.business.payrollcalculation.notifications.PayrollCalculationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeletePayrollCalculationService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeletePayrollCalculationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_calculations").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollCalculationNotificationFactory.DeletePayrollCalculationSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollCalculationNotificationFactory.DeletePayrollCalculationFail())
                    .get();
        }
        return builder.get();
    }

}
