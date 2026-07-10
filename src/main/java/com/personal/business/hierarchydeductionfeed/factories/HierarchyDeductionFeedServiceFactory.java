package com.personal.business.hierarchydeductionfeed.factories;

import com.personal.business.hierarchydeductionfeed.filter.services.FilterHierarchyDeductionFeedService;
import com.personal.business.hierarchydeductionfeed.notifications.HierarchyDeductionFeedNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class HierarchyDeductionFeedServiceFactory {

    private static final String TABLE_NAME = "hierarchies_deductions_feeds";

    public static CreateService CreateHierarchyDeductionFeed(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionFeedNotificationFactory.CreateHierarchyDeductionFeedSuccess())
                .withFailureNotification(HierarchyDeductionFeedNotificationFactory.CreateHierarchyDeductionFeedFail())
                .build();
    }

    public static FilterHierarchyDeductionFeedService FilterHierarchyDeductionFeed(String dbClient) {

        return new FilterHierarchyDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditHierarchyDeductionFeed(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionFeedNotificationFactory.UpdateHierarchyDeductionFeedSuccess())
                .withFailureNotification(HierarchyDeductionFeedNotificationFactory.UpdateHierarchyDeductionFeedFail())
                .build();
    }

    public static DeleteService DeleteHierarchyDeductionFeed(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionFeedNotificationFactory.DeleteHierarchyDeductionFeedSuccess())
                .withFailureNotification(HierarchyDeductionFeedNotificationFactory.DeleteHierarchyDeductionFeedFail())
                .build();
    }

}
