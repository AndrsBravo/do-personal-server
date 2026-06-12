package com.personal.management.orghierarchy.delete.services;

import java.util.Optional;

import com.personal.management.orghierarchy.entities.OrgHierarchy;
import com.personal.management.orghierarchy.factories.OrgHierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteOrgHierarchyService implements IDeleteService<OrgHierarchy> {

    private final Optional<DbClient> dbClient;

    public DeleteOrgHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgHierarchy> delete(Query query) {
        if (dbClient.isEmpty()) {
            return OrgHierarchyResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("organization_hierarchies").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al eliminar el tipo de usuario " + e.getMessage());
            return OrgHierarchyResultFactory.DeleteFail();
        }

        if (result == 0) {
            return OrgHierarchyResultFactory.DeleteFail();
        }

        return OrgHierarchyResultFactory.DeleteSuccess(new OrgHierarchy(query.getParams().get("id")));

    }

}
