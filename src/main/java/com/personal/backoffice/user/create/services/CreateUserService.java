package com.personal.backoffice.user.create.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateUserService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateUserService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var userQuery = query.InsertInto("users").Get();

        //System.out.println(userQuery);
        try {

            var records = dbclient.execute()
                    .createInsert(userQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(UserNotificationFactory.CreateUserSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(UserNotificationFactory.CreateUserFail())
                    .get();
        }
    }
}
