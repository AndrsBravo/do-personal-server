package com.personal.business.hierarchybenefitfeed.factories;

import com.personal.business.hierarchybenefitfeed.filter.services.FilterHierarchyBenefitFeedService;
import com.personal.business.hierarchybenefitfeed.notifications.HierarchyBenefitFeedNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class HierarchyBenefitFeedServiceFactory {

    private static final String TABLE_NAME = "hierarchies_benefits_feeds";

    public static CreateService CreateHierarchyBenefitFeed(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitFeedNotificationFactory.CreateHierarchyBenefitFeedSuccess())
                .withFailureNotification(HierarchyBenefitFeedNotificationFactory.CreateHierarchyBenefitFeedFail())
                .build();
    }

    public static FilterHierarchyBenefitFeedService FilterHierarchyBenefitFeed(String dbClient) {

        return new FilterHierarchyBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditHierarchyBenefitFeed(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitFeedNotificationFactory.UpdateHierarchyBenefitFeedSuccess())
                .withFailureNotification(HierarchyBenefitFeedNotificationFactory.UpdateHierarchyBenefitFeedFail())
                .build();
    }

    public static DeleteService DeleteHierarchyBenefitFeed(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitFeedNotificationFactory.DeleteHierarchyBenefitFeedSuccess())
                .withFailureNotification(HierarchyBenefitFeedNotificationFactory.DeleteHierarchyBenefitFeedFail())
                .build();
    }

}
