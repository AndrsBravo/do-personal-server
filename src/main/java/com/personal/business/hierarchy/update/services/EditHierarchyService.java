package com.personal.business.hierarchy.update.services;

import java.util.Optional;

import com.personal.business.hierarchy.entities.Hierarchy;
import com.personal.business.hierarchy.factories.HierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditHierarchyService implements IEditService<Hierarchy> {

    private final Optional<DbClient> dbClient;

    public EditHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Hierarchy> edit(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("business_hierarchies").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return HierarchyResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return HierarchyResultFactory.UpdateFail();
        }

        return HierarchyResultFactory.UpdateSuccess(new Hierarchy());

    }

}
