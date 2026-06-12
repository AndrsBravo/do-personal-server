package com.personal.backoffice.client.create.services;

import java.util.Optional;

import com.personal.backoffice.client.entities.Client;
import com.personal.backoffice.client.factories.ClientResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateClientService implements ICreateService<Client> {

    private final Optional<DbClient> dbClient;

    public CreateClientService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Client> create(Query query) {
        if (dbClient.isEmpty()) {
            return ClientResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("clients").Get();

        //System.out.println(insertQuery);
        //System.out.println(query.getParams());
        long result = 0;

        try {
            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de cliente " + e.getMessage());
            return ClientResultFactory.CreateFail();
        }

        if (result == 0) {
            return ClientResultFactory.CreateFail();
        }

        return ClientResultFactory.CreateSuccess(new Client());

    }

}
