package com.personal.backoffice.client.delete.services;

import java.util.Optional;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteClientService implements IDeleteService<Client> {

    private final Optional<DbClient> dbClient;

    public DeleteClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Client> delete(Query query) {
        if (dbClient.isEmpty()) {
            return ClientResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("clients").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de cliente " + e.getMessage());
            return ClientResultFactory.DeleteFail();
        }

        if (result == 0) {
            return ClientResultFactory.DeleteFail();
        }

        return ClientResultFactory.DeleteSuccess(new Client(query.getParams().get("id")));

    }

}
