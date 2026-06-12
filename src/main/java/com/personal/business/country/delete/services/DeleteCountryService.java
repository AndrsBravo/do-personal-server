package com.personal.business.country.delete.services;

import java.util.Optional;

import com.personal.backoffice.country.entities.Country;
import com.personal.business.country.factories.CountryResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteCountryService implements IDeleteService<Country> {

    private final Optional<DbClient> dbClient;

    public DeleteCountryService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Country> delete(Query query) {
        if (dbClient.isEmpty()) {
            return CountryResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("countries").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de cliente " + e.getMessage());
            return CountryResultFactory.DeleteFail();
        }

        if (result == 0) {
            return CountryResultFactory.DeleteFail();
        }

        return CountryResultFactory.DeleteSuccess(new Country(query.getParams().get("id")));

    }

}
