package com.personal.business.hierarchydeductionfeed.create.services;

import java.util.Optional;

import com.personal.business.hierarchydeductionfeed.notifications.HierarchyDeductionFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class CreateHierarchyDeductionFeedService implements ICreateService {

    private final Optional<DbClient> dbClient;

    public CreateHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult create(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("hierarchies_deductions_feeds").Get();

        try {

            var records = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
            return ServiceResultBuilder.build()
                    .withRecords(records)
                    .withNotification(HierarchyDeductionFeedNotificationFactory.CreateHierarchyDeductionFeedSuccess())
                    .get();
        } catch (Exception e) {

            return ServiceResultBuilder.build()
                    .withException(e)
                    .withNotification(HierarchyDeductionFeedNotificationFactory.CreateHierarchyDeductionFeedFail())
                    .get();
        }

    }

}
