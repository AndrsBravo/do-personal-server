package com.personal.business.hierarchy.create.services;

import java.util.Optional;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.factories.HierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyService implements ICreateService<Hierarchy> {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Hierarchy> create(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_hierarchies").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return HierarchyResultFactory.CreateFail();
        }

        if (result == 0) {
            return HierarchyResultFactory.CreateFail();
        }

        return HierarchyResultFactory.CreateSuccess(new Hierarchy());

    }

}
