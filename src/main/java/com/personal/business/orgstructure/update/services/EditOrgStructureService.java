package com.personal.business.orgstructure.update.services;

import java.util.Optional;

import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.factories.OrgStructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditOrgStructureService implements IEditService<OrgStructure> {

    private final Optional<DbClient> dbClient;

    public EditOrgStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgStructure> edit(Query query) {

        if (dbClient.isEmpty()) {
            return OrgStructureResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("organization_structures").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return OrgStructureResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return OrgStructureResultFactory.UpdateFail();
        }

        return OrgStructureResultFactory.UpdateSuccess(new OrgStructure());

    }

}
