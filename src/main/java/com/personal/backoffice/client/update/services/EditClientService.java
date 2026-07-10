package com.personal.backoffice.client.update.services;

import java.util.Optional;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditClientService implements IEditService<Client> {

    private final Optional<DbClient> dbClient;

    public EditClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Client> edit(Query query) {

        if (dbClient.isEmpty()) {
            return ClientResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("clients").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de cliente " + e.getMessage());
            return ClientResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return ClientResultFactory.UpdateFail();
        }

        return ClientResultFactory.UpdateSuccess(new Client());

    }

}
