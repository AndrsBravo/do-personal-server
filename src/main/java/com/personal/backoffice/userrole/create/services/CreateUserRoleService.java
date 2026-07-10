package com.personal.backoffice.userrole.create.services;

import java.util.Optional;

import com.personal.backoffice.userrole.notifications.UserRoleNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateUserRoleService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateUserRoleService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_role").Get();

        System.out.println(insertQuery);
        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(UserRoleNotificationFactory.CreateUserRoleSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(UserRoleNotificationFactory.CreateUserRoleFail())
                    .get();
        }
    }

}
