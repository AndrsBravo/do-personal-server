package com.personal.business.employeescale.update.services;

import java.util.Optional;

import com.personal.business.employeescale.notifications.EmployeeScaleNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditEmployeeScaleService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditEmployeeScaleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("employee_scale").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(EmployeeScaleNotificationFactory.UpdateEmployeeScaleSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(EmployeeScaleNotificationFactory.UpdateEmployeeScaleFail());

        }
        return builder.get();
    }

}
