package com.personal.backoffice.commercial.entity.delete.services;

import java.util.Optional;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.factories.CommercialEntityResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteCommercialEntityService implements IDeleteService<CommercialEntity> {

    private final Optional<DbClient> dbClient;

    public DeleteCommercialEntityService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialEntity> delete(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialEntityResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("commercial_entities").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return CommercialEntityResultFactory.DeleteFail();
        }

        if (result == 0) {
            return CommercialEntityResultFactory.DeleteFail();
        }

        return CommercialEntityResultFactory.DeleteSuccess(new CommercialEntity(query.getParams().get("id")));

    }

}
