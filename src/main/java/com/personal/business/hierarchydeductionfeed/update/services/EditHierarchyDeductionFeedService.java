package com.personal.business.hierarchydeductionfeed.update.services;

import java.util.Optional;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditHierarchyDeductionFeedService implements IEditService<HierarchyDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public EditHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeductionFeed> edit(Query query) {

        if (dbClient.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("hierarchies_deductions_feeds").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return HierarchyDeductionFeedResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return HierarchyDeductionFeedResultFactory.UpdateFail();
        }

        return HierarchyDeductionFeedResultFactory.UpdateSuccess(new HierarchyDeductionFeed());

    }

}
