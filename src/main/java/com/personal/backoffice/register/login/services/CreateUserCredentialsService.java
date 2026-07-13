package com.personal.backoffice.register.login.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateUserCredentialsService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateUserCredentialsService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult create(Query query) {

        var oldCreadentialsQuery = "INSERT INTO credentials (id,user_id,password,salt,created_at,updated_at,created_by) VALUES (:id,:user_id,:password,:salt,:created_at,:updated_at,:created_by)";

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var credentialsQuery = query.InsertInto("credentials").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(credentialsQuery)
                    .params(query.getParams())
                    .execute();
            return ServiceResultBuilder.build()
                    .withRecords(records)
                    .withNotification(UserNotificationFactory.CreateUserCredentialsSuccess())
                    .get();
        } catch (Exception e) {

            return ServiceResultBuilder.build()
                    .withException(e)
                    .withNotification(UserNotificationFactory.CreateUserCredentialsFail())
                    .get();
        }
    }
}
