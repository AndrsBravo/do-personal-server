package com.personal.backoffice.clienttype.delete.services;

import java.util.Optional;

import com.personal.backoffice.clienttype.factories.ClientTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteClientTypeService implements IDeleteService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public DeleteClientTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntityBase> delete(Query query) {
        if (dbClient.isEmpty()) {
            return ClientTypeResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("client_types").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de cliente " + e.getMessage());
            return ClientTypeResultFactory.DeleteFail();
        }

        if (result == 0) {
            return ClientTypeResultFactory.DeleteFail();
        }

        return ClientTypeResultFactory.DeleteSuccess(new TypeEntityBase(query.getParams().get("id")));

    }

}
