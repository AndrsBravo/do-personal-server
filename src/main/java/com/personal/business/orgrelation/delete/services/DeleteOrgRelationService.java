package com.personal.business.orgrelation.delete.services;

import java.util.Optional;

import com.personal.business.orgrelation.notifications.OrgRelationNotificationFactory;
import com.personal.shared.factories.ServicesResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;
import com.personal.shared.services.entities.ServiceResultBuilder;

import io.helidon.dbclient.DbClient;

public class DeleteOrgRelationService implements IDeleteService {

    private final Optional<DbClient> dbClient;

    public DeleteOrgRelationService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult delete(Query query) {
        if (dbClient.isEmpty()) {
            return ServicesResultFactory.NotAvailable();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("organization_relations").Get();

        var builder = ServiceResultBuilder.build();
        try {
            var records = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

            builder.withRecords(records)
                    .withNotification(OrgRelationNotificationFactory.DeleteOrgRelationSuccess())
                    .get();
        } catch (Exception e) {
            builder.withException(e)
                    .withNotification(OrgRelationNotificationFactory.DeleteOrgRelationFail())
                    .get();
        }
        return builder.get();
    }

}
