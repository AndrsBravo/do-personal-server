package com.personal.business.payrollcalculationresult.delete.services;

import java.util.Optional;

import com.personal.business.payrollcalculationresult.notifications.PayrollCalculationResultNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeletePayrollCalculationResultService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeletePayrollCalculationResultService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_calculations_results").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollCalculationResultNotificationFactory.DeletePayrollCalculationResultSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollCalculationResultNotificationFactory.DeletePayrollCalculationResultFail())
                    .get();
        }
        return builder.get();
    }

}
