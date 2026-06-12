package com.personal.business.orgstructure.delete.services;

import java.util.Optional;

import com.personal.business.orgstructure.entities.OrgStructure;
import com.personal.business.orgstructure.factories.OrgStructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteOrgStructureService implements IDeleteService<OrgStructure> {

    private final Optional<DbClient> dbClient;

    public DeleteOrgStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgStructure> delete(Query query) {
        if (dbClient.isEmpty()) {
            return OrgStructureResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("organization_structures").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return OrgStructureResultFactory.DeleteFail();
        }

        if (result == 0) {
            return OrgStructureResultFactory.DeleteFail();
        }

        return OrgStructureResultFactory.DeleteSuccess(new OrgStructure(query.getParams().get("id")));

    }

}
