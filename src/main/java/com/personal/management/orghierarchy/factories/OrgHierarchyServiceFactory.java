package com.personal.management.orghierarchy.factories;

import com.personal.management.orghierarchy.filter.services.FilterOrgHierarchyService;
import com.personal.management.orghierarchy.notifications.OrgHierarchyNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgHierarchyServiceFactory {

    private static final String TABLE_NAME = "organization_hierarchies";

    public static CreateService CreateOrgHierarchy() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgHierarchyNotificationFactory.CreateOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.CreateOrgHierarchyFail())
                .build();
    }

    public static FilterOrgHierarchyService FilterOrgHierarchy() {

        return new FilterOrgHierarchyService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditOrgHierarchy() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgHierarchyNotificationFactory.UpdateOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.UpdateOrgHierarchyFail())
                .build();
    }

    public static DeleteService DeleteOrgHierarchy() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchySuccess())
                .withFailureNotification(OrgHierarchyNotificationFactory.DeleteOrgHierarchyFail())
                .build();
    }

}
