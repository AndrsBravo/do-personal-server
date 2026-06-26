package com.personal.business.hierarchybenefitfeed.create.services;

import java.util.Optional;

import com.personal.business.hierarchybenefitfeed.entities.HierarchyBenefitFeed;
import com.personal.business.hierarchybenefitfeed.factories.HierarchyBenefitFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyBenefitFeedService implements ICreateService<HierarchyBenefitFeed> {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyBenefitFeed> create(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyBenefitFeedResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_benefits_feeds").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return HierarchyBenefitFeedResultFactory.CreateFail();
        }

        if (result == 0) {
            return HierarchyBenefitFeedResultFactory.CreateFail();
        }

        return HierarchyBenefitFeedResultFactory.CreateSuccess(new HierarchyBenefitFeed());

    }

}
