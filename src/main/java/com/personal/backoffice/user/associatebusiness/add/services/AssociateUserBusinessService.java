package com.personal.backoffice.user.associatebusiness.add.services;

import java.util.Optional;

import com.personal.backoffice.user.notifications.UserNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class AssociateUserBusinessService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public AssociateUserBusinessService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult create(Query query) {
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

            return ServiceResultBuilder.build()
                    .withRecords(records)
                    .withNotification(UserNotificationFactory.AssociateUserBusinessSuccess())
                    .get();
        } catch (Exception e) {

            return ServiceResultBuilder.build()
                    .withException(e)
                    .withNotification(UserNotificationFactory.AssociateUserBusinessFail())
                    .get();
        }
    }

}
