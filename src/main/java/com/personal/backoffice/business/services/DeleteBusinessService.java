package com.personal.backoffice.business.services;

import java.util.Optional;

import com.personal.backoffice.business.notifications.BusinessNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteBusinessService implements IDeleteService {

    private final Optional<DbClient> dbBusiness;

    public DeleteBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbBusiness.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbBusiness.get();

        var deleteQuery = query.Delete("business").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(BusinessNotificationFactory.DeleteBusinessSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(BusinessNotificationFactory.DeleteBusinessFail())
                    .get();
        }
        return builder.get();
    }

}
