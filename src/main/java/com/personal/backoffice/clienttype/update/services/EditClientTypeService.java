package com.personal.backoffice.clienttype.update.services;

import java.util.Optional;

import com.personal.backoffice.clienttype.factories.ClientTypeResultFactory;
import com.personal.shared.entities.TypeEntityBase;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditClientTypeService implements IEditService<TypeEntityBase> {

    private final Optional<DbClient> dbClient;

    public EditClientTypeService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TypeEntityBase> edit(Query query) {

        if (dbClient.isEmpty()) {
            return ClientTypeResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("client_types").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de cliente " + e.getMessage());
            return ClientTypeResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return ClientTypeResultFactory.UpdateFail();
        }

        return ClientTypeResultFactory.UpdateSuccess(new TypeEntityBase());

    }

}
