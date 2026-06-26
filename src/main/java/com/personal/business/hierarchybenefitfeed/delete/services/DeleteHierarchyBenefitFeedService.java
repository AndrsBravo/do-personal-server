package com.personal.business.hierarchybenefitfeed.delete.services;

import java.util.Optional;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyBenefitFeedService implements IDeleteService<HierarchyBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyBenefitFeed> delete(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyBenefitFeedResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_benefits_feeds").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return HierarchyBenefitFeedResultFactory.DeleteFail();
        }

        if (result == 0) {
            return HierarchyBenefitFeedResultFactory.DeleteFail();
        }

        return HierarchyBenefitFeedResultFactory.DeleteSuccess(new HierarchyBenefitFeed(query.getParams().get("id")));

    }

}
