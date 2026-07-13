package com.personal.business.hierarchybenefitfeed.delete.services;

import java.util.Optional;

import com.personal.business.hierarchybenefitfeed.notifications.HierarchyBenefitFeedNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyBenefitFeedService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyBenefitFeedService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_benefits_feeds").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(HierarchyBenefitFeedNotificationFactory.DeleteHierarchyBenefitFeedSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(HierarchyBenefitFeedNotificationFactory.DeleteHierarchyBenefitFeedFail())
                    .get();
        }
        return builder.get();
    }

}
