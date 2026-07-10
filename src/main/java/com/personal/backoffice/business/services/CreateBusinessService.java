package com.personal.backoffice.business.services;

import java.util.Optional;

import com.personal.backoffice.business.notifications.BusinessNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateBusinessService implements ICreateService {

    private final Optional<DbClient> dbBusiness;

    public CreateBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbBusiness.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbBusiness.get();

        var insertQuery = query.InsertInto("business").Get();

        System.out.println(insertQuery);

        try {
            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(BusinessNotificationFactory.CreateBusinessSuccess())
                    .get();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de empresa " + e.getMessage());
            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(BusinessNotificationFactory.CreateBusinessFail())
                    .get();
        }

    }

}
