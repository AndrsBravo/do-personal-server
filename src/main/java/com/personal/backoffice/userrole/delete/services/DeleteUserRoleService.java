package com.personal.backoffice.userrole.delete.services;

import java.util.Optional;

import com.personal.backoffice.userrole.notifications.UserRoleNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteUserRoleService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("user_role").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(UserRoleNotificationFactory.DeleteUserRoleSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(UserRoleNotificationFactory.DeleteUserRoleFail())
                    .get();
        }
        return builder.get();
    }

}
