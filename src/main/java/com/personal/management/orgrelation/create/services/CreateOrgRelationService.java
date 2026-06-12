package com.personal.management.orgrelation.create.services;

import java.util.Optional;

import com.personal.management.orgrelation.entities.OrgRelation;
import com.personal.management.orgrelation.factories.OrgRelationResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateOrgRelationService implements ICreateService<OrgRelation> {

    private final Optional<DbClient> dbClient;

    public CreateOrgRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgRelation> create(Query query) {
        if (dbClient.isEmpty()) {
            return OrgRelationResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("organization_relations").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return OrgRelationResultFactory.CreateFail();
        }

        if (result == 0) {
            return OrgRelationResultFactory.CreateFail();
        }

        return OrgRelationResultFactory.CreateSuccess(new OrgRelation());

    }

}
