package com.personal.business.orgrelation.update.services;

import java.util.Optional;

import com.personal.business.orgrelation.entities.OrgRelation;
import com.personal.business.orgrelation.factories.OrgRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditOrgRelationService implements IEditService<OrgRelation> {

    private final Optional<DbClient> dbClient;

    public EditOrgRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgRelation> edit(Query query) {

        if (dbClient.isEmpty()) {
            return OrgRelationResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("organization_relations").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return OrgRelationResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return OrgRelationResultFactory.UpdateFail();
        }

        return OrgRelationResultFactory.UpdateSuccess(new OrgRelation());

    }

}
