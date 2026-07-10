package com.personal.management.orgrelation.factories;

import com.personal.management.orgrelation.filter.services.FilterOrgRelationService;
import com.personal.management.orgrelation.notifications.OrgRelationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgRelationServiceFactory {

    private static final String TABLE_NAME = "organization_relations";

    public static CreateService CreateOrgRelation() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgRelationNotificationFactory.CreateOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.CreateOrgRelationFail())
                .build();
    }

    public static FilterOrgRelationService FilterOrgRelation() {

        return new FilterOrgRelationService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditOrgRelation() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgRelationNotificationFactory.UpdateOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.UpdateOrgRelationFail())
                .build();
    }

    public static DeleteService DeleteOrgRelation() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgRelationNotificationFactory.DeleteOrgRelationSuccess())
                .withFailureNotification(OrgRelationNotificationFactory.DeleteOrgRelationFail())
                .build();
    }

}
