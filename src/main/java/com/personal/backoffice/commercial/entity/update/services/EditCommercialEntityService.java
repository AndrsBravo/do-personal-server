package com.personal.backoffice.commercial.entity.update.services;

import java.util.Optional;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.factories.CommercialEntityResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditCommercialEntityService implements IEditService<CommercialEntity> {

    private final Optional<DbClient> dbClient;

    public EditCommercialEntityService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialEntity> edit(Query query) {

        if (dbClient.isEmpty()) {
            return CommercialEntityResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("commercial_entities").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return CommercialEntityResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return CommercialEntityResultFactory.UpdateFail();
        }

        return CommercialEntityResultFactory.UpdateSuccess(new CommercialEntity());

    }

}
