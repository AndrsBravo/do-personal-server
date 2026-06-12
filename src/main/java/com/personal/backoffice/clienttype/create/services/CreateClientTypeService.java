package com.personal.backoffice.clienttype.create.services;

import java.util.Optional;

import com.personal.backoffice.clienttype.factories.ClientTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateClientTypeService implements ICreateService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public CreateClientTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntityBase> create(Query query) {
        if (dbClient.isEmpty()) {
            return ClientTypeResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("client_types").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de cliente " + e.getMessage());
            return ClientTypeResultFactory.CreateFail();
        }

        if (result == 0) {
            return ClientTypeResultFactory.CreateFail();
        }

        return ClientTypeResultFactory.CreateSuccess(new TypeEntityBase());

    }

}
