package com.personal.business.hierarchydeductionfeed.delete.services;

import java.util.Optional;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyDeductionFeedService implements IDeleteService<HierarchyDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeductionFeed> delete(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_deductions_feeds").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return HierarchyDeductionFeedResultFactory.DeleteFail();
        }

        if (result == 0) {
            return HierarchyDeductionFeedResultFactory.DeleteFail();
        }

        return HierarchyDeductionFeedResultFactory.DeleteSuccess(new HierarchyDeductionFeed(query.getParams().get("id")));

    }

}
