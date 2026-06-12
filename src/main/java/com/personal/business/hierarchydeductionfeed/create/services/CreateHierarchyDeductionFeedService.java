package com.personal.business.hierarchydeductionfeed.create.services;

import java.util.Optional;

import com.personal.business.hierarchydeductionfeed.entities.HierarchyDeductionFeed;
import com.personal.business.hierarchydeductionfeed.factories.HierarchyDeductionFeedResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyDeductionFeedService implements ICreateService<HierarchyDeductionFeed> {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<HierarchyDeductionFeed> create(Query query) {
        if (dbClient.isEmpty()) {
            return HierarchyDeductionFeedResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_deductions_feeds").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return HierarchyDeductionFeedResultFactory.CreateFail();
        }

        if (result == 0) {
            return HierarchyDeductionFeedResultFactory.CreateFail();
        }

        return HierarchyDeductionFeedResultFactory.CreateSuccess(new HierarchyDeductionFeed());

    }

}
