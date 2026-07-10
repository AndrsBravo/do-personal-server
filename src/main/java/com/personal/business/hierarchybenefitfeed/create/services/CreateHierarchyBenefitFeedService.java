package com.personal.business.hierarchybenefitfeed.create.services;

import java.util.Optional;

import com.personal.business.hierarchybenefitfeed.notifications.HierarchyBenefitFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.CreateResult;
import com.personal.shared.services.entities.CreateResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyBenefitFeedService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public CreateResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_benefits_feeds").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return CreateResultBuilder.build()
                    .withRecords(records)
                    .withNotification(HierarchyBenefitFeedNotificationFactory.CreateHierarchyBenefitFeedSuccess())
                    .get();
        } catch (Exception e) {

            return CreateResultBuilder.build()
                    .withException(e)
                    .withNotification(HierarchyBenefitFeedNotificationFactory.CreateHierarchyBenefitFeedFail())
                    .get();
        }

    }

}
