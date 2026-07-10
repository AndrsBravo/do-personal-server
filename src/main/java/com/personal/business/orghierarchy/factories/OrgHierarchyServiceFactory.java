package com.personal.business.orghierarchy.factories;

import com.personal.business.orghierarchy.filter.services.FilterOrgHierarchyService;
import com.personal.business.orghierarchy.notifications.OrgHierarchyNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgHierarchyServiceFactory {

    private static final String TABLE_NAME = "organization_hierarchies";

    public static CreateService CreateOrgHierarchy(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgHierarchyNotificationFactory.CreateOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.CreateOrgHierarchyFail())
                .build();
    }

    public static FilterOrgHierarchyService FilterOrgHierarchy(String dbClient) {

        return new FilterOrgHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditOrgHierarchy(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgHierarchyNotificationFactory.UpdateOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.UpdateOrgHierarchyFail())
                .build();
    }

    public static DeleteService DeleteOrgHierarchy(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchyFail())
                .build();
    }

}
