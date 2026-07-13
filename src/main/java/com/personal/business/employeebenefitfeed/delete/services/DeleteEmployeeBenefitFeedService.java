package com.personal.business.employeebenefitfeed.delete.services;

import java.util.Optional;

import com.personal.business.employeebenefitfeed.notifications.EmployeeBenefitFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteEmployeeBenefitFeedService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteEmployeeBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("employee_benefits_feeds").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(EmployeeBenefitFeedNotificationFactory.DeleteEmployeeBenefitFeedSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(EmployeeBenefitFeedNotificationFactory.DeleteEmployeeBenefitFeedFail())
                    .get();
        }
        return builder.get();
    }

}
