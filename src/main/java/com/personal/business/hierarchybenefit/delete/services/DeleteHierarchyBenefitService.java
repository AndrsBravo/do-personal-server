package com.personal.business.hierarchybenefit.delete.services;

import java.util.Optional;

import com.personal.business.hierarchybenefit.notifications.HierarchyBenefitNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteHierarchyBenefitService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteHierarchyBenefitService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("hierarchies_benefits").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(HierarchyBenefitNotificationFactory.DeleteHierarchyBenefitSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(HierarchyBenefitNotificationFactory.DeleteHierarchyBenefitFail())
                    .get();
        }
        return builder.get();
    }

}
