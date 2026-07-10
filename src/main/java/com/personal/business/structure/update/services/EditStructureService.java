package com.personal.business.structure.update.services;

import java.util.Optional;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.factories.StructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditStructureService implements IEditService<Structure> {

    private final Optional<DbClient> dbClient;

    public EditStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Structure> edit(Query query) {

        if (dbClient.isEmpty()) {
            return StructureResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_structures").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return StructureResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return StructureResultFactory.UpdateFail();
        }

        return StructureResultFactory.UpdateSuccess(new Structure());

    }

}
