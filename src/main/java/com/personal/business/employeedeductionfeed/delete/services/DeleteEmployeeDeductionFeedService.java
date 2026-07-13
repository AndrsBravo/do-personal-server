package com.personal.business.employeedeductionfeed.delete.services;

import java.util.Optional;

import com.personal.business.employeedeductionfeed.notifications.EmployeeDeductionFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeDeductionFeedService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_deductions_feeds").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(EmployeeDeductionFeedNotificationFactory.DeleteEmployeeDeductionFeedSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(EmployeeDeductionFeedNotificationFactory.DeleteEmployeeDeductionFeedFail())
                    .get();
        }
        return builder.get();
    }

}
