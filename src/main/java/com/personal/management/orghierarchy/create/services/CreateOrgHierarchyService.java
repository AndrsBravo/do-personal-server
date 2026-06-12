package com.personal.management.orghierarchy.create.services;

import java.util.Optional;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.orghierarchy.factories.OrgHierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateOrgHierarchyService implements ICreateService<OrgHierarchy> {

    private final Optional<DbClient> dbClient;

    public CreateOrgHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgHierarchy> create(Query query) {
        if (dbClient.isEmpty()) {
            return OrgHierarchyResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("organization_hierarchies").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return OrgHierarchyResultFactory.CreateFail();
        }

        if (result == 0) {
            return OrgHierarchyResultFactory.CreateFail();
        }

        return OrgHierarchyResultFactory.CreateSuccess(new OrgHierarchy());

    }

}
