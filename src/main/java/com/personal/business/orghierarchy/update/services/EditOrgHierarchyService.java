package com.personal.business.orghierarchy.update.services;

import java.util.Optional;

import com.personal.business.orghierarchy.entities.OrgHierarchy;
import com.personal.business.orghierarchy.factories.OrgHierarchyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditOrgHierarchyService implements IEditService<OrgHierarchy> {

    private final Optional<DbClient> dbClient;

    public EditOrgHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<OrgHierarchy> edit(Query query) {

        if (dbClient.isEmpty()) {
            return OrgHierarchyResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("organization_hierarchies").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return OrgHierarchyResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return OrgHierarchyResultFactory.UpdateFail();
        }

        return OrgHierarchyResultFactory.UpdateSuccess(new OrgHierarchy());

    }

}
