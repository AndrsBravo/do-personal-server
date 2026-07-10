package com.personal.business.structure.delete.services;

import java.util.Optional;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.factories.StructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteStructureService implements IDeleteService<Structure> {

    private final Optional<DbClient> dbClient;

    public DeleteStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Structure> delete(Query query) {
        if (dbClient.isEmpty()) {
            return StructureResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_structures").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return StructureResultFactory.DeleteFail();
        }

        if (result == 0) {
            return StructureResultFactory.DeleteFail();
        }

        return StructureResultFactory.DeleteSuccess(new Structure(query.getParams().get("id")));

    }

}
