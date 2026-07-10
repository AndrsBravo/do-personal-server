package com.personal.business.orgrelation.factories;

import com.personal.business.orgrelation.filter.services.FilterOrgRelationService;
import com.personal.business.orgrelation.notifications.OrgRelationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgRelationServiceFactory {

    private static final String TABLE_NAME = "organization_relations";

    public static CreateService CreateOrgRelation(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgRelationNotificationFactory.CreateOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.CreateOrgRelationFail())
                .build();
    }

    public static FilterOrgRelationService FilterOrgRelation(String dbClient) {

        return new FilterOrgRelationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditOrgRelation(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgRelationNotificationFactory.UpdateOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.UpdateOrgRelationFail())
                .build();
    }

    public static DeleteService DeleteOrgRelation(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgRelationNotificationFactory.DeleteOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.DeleteOrgRelationFail())
                .build();
    }

}
