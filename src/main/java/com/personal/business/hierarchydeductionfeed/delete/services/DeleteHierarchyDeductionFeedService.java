package com.personal.business.hierarchydeductionfeed.delete.services;

import java.util.Optional;

import com.personal.business.hierarchydeductionfeed.notifications.HierarchyDeductionFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyDeductionFeedService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyDeductionFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_deductions_feeds").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(HierarchyDeductionFeedNotificationFactory.DeleteHierarchyDeductionFeedSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(HierarchyDeductionFeedNotificationFactory.DeleteHierarchyDeductionFeedFail())
                    .get();
        }
        return builder.get();
    }

}
