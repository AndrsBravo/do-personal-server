package com.personal.backoffice.usertype.update.services;

import java.util.Optional;

import com.personal.backoffice.usertype.notifications.UserTypeNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditUserTypeService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditUserTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("user_types").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserTypeNotificationFactory.UpdateUserTypeSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserTypeNotificationFactory.UpdateUserTypeFail());

        }
        return builder.get();
    }

}
