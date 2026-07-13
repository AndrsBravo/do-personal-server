package com.personal.backoffice.business.services;

import java.util.Optional;

import com.personal.backoffice.business.notifications.BusinessNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditBusinessService implements IEditService {

    private final Optional<DbClient> dbBusiness;

    public EditBusinessService(Optional<DbClient> dbBusiness) {
        this.dbBusiness = dbBusiness;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbBusiness.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbBusiness.get();

        var updateQuery = query.Update("business").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(BusinessNotificationFactory.UpdateBusinessSuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(BusinessNotificationFactory.UpdateBusinessFail());

        }
        return builder.get();
    }

}
