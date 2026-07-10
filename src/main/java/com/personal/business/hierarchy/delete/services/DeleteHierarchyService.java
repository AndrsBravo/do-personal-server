package com.personal.business.hierarchy.delete.services;

import java.util.Optional;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.factories.HierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyService implements IDeleteService<Hierarchy> {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Hierarchy> delete(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("business_hierarchies").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return HierarchyResultFactory.DeleteFail();
        }

        if (result == 0) {
            return HierarchyResultFactory.DeleteFail();
        }

        return HierarchyResultFactory.DeleteSuccess(new Hierarchy(query.getParams().get("id")));

    }

}
