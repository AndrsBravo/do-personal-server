package com.personal.management.orghierarchy.delete.services;

import java.util.Optional;

import com.personal.management.orghierarchy.notifications.OrgHierarchyNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteOrgHierarchyService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteOrgHierarchyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("organization_hierarchies").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchySuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchyFail())
                    .get();
        }
        return builder.get();
    }

}
