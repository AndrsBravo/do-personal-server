package com.personal.backoffice.user.associatebusiness.add.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class AssociateUserBusinessService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public AssociateUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("user_has_business").Get();

        //System.out.println(query.getParams());
        try {
            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(UserNotificationFactory.AssociateUserBusinessSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(UserNotificationFactory.AssociateUserBusinessFail())
                    .get();
        }
    }

}
