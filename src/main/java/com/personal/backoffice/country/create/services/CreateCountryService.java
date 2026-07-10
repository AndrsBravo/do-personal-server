package com.personal.backoffice.country.create.services;

import java.util.Optional;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.factories.CountryResultFactory;
import com.personal.backoffice.country.notifications.CountryNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateCountryService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("countries").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(CountryNotificationFactory.CreateCountrySuccess())
                    .get();

        } catch (Exception e) {
            System.out.println("Hubo una excepción al crear el país " + e.getCause().getMessage());

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(CountryNotificationFactory.CreateCountryFail(e.getMessage()))
                    .get();

        }

    }

}
