package com.personal.management.orgrelation.delete.services;

import java.util.Optional;

import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.orgrelation.factories.OrgRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteOrgRelationService implements IDeleteService<OrgRelation> {

    private final Optional<DbClient> dbClient;

    public DeleteOrgRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgRelation> delete(Query query) {
        if (dbClient.isEmpty()) {
            return OrgRelationResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("organization_relations").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return OrgRelationResultFactory.DeleteFail();
        }

        if (result == 0) {
            return OrgRelationResultFactory.DeleteFail();
        }

        return OrgRelationResultFactory.DeleteSuccess(new OrgRelation(query.getParams().get("id")));

    }

}
