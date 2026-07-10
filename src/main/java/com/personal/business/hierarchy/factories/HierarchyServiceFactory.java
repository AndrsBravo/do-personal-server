package com.personal.business.hierarchy.factories;

import com.personal.business.hierarchy.filter.services.FilterHierarchyService;
import com.personal.business.hierarchy.notifications.HierarchyNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class HierarchyServiceFactory {

    private static final String TABLE_NAME = "business_hierarchies";

    public static CreateService CreateHierarchy(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyNotificationFactory.CreateHierarchySuccess())
                .withFailureNotification(HierarchyNotificationFactory.CreateHierarchyFail())
                .build();
    }

    public static FilterHierarchyService FilterHierarchy(String dbClient) {

        return new FilterHierarchyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditHierarchy(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyNotificationFactory.UpdateHierarchySuccess())
                .withFailureNotification(HierarchyNotificationFactory.UpdateHierarchyFail())
                .build();
    }

    public static DeleteService DeleteHierarchy(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyNotificationFactory.DeleteHierarchySuccess())
                .withFailureNotification(HierarchyNotificationFactory.DeleteHierarchyFail())
                .build();
    }

}
