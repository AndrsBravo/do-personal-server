package com.personal.management.orgstructure.create.services;

import java.util.Optional;

import com.personal.management.orgstructure.entities.OrgStructure;
import com.personal.management.orgstructure.factories.OrgStructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateOrgStructureService implements ICreateService<OrgStructure> {

    private final Optional<DbClient> dbClient;

    public CreateOrgStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgStructure> create(Query query) {
        if (dbClient.isEmpty()) {
            return OrgStructureResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("organization_structures").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return OrgStructureResultFactory.CreateFail();
        }

        if (result == 0) {
            return OrgStructureResultFactory.CreateFail();
        }

        return OrgStructureResultFactory.CreateSuccess(new OrgStructure());

    }

}
