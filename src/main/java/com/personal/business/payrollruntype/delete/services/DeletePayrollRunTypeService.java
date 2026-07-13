package com.personal.business.payrollruntype.delete.services;

import java.util.Optional;

import com.personal.business.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeletePayrollRunTypeService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeletePayrollRunTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("payroll_runs_types").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeFail())
                    .get();
        }
        return builder.get();
    }

}
