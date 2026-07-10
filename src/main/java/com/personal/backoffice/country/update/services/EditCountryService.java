package com.personal.backoffice.country.update.services;

import java.util.Optional;

import com.personal.backoffice.country.entities.Country;
import com.personal.backoffice.country.factories.CountryResultFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditCountryService implements IEditService<Country> {

    private final Optional<DbClient> dbClient;

    public EditCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Country> edit(Query query) {

        if (dbClient.isEmpty()) {
            return ServicesResultFactory.<Country>DbNotAvailable();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("countries").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de cliente " + e.getMessage());
            return CountryResultFactory.UpdateFail(e.getMessage());
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return CountryResultFactory.UpdateFail("No se pudo actualizar el país.");
        }

        return CountryResultFactory.UpdateSuccess(new Country());

    }

}
