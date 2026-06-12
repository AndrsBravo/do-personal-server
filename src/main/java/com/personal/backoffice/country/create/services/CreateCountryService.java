package com.personal.backoffice.country.create.services;

import java.util.Optional;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.factories.CountryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateCountryService implements ICreateService<Country> {

    private final Optional<DbClient> dbClient;

    public CreateCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Country> create(Query query) {
        if (dbClient.isEmpty()) {
            return CountryResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("countries").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de cliente " + e.getMessage());
            return CountryResultFactory.CreateFail();
        }

        if (result == 0) {
            return CountryResultFactory.CreateFail();
        }

        return CountryResultFactory.CreateSuccess(new Country());

    }

}
