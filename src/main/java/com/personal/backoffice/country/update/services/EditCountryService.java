package com.personal.backoffice.country.update.services;

import java.util.Optional;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.notifications.CountryNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class EditCountryService implements IEditService {

    private final Optional<DbClient> dbClient;

    public EditCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.<Country>DbNotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("countries").Get();
        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(CountryNotificationFactory.UpdateCountrySuccess());

        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(CountryNotificationFactory.UpdateCountryFail());

        }
        return builder.get();
    }

}
