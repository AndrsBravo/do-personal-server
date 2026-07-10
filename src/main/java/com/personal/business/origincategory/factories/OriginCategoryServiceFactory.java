package com.personal.business.origincategory.factories;

import com.personal.business.origincategory.filter.services.FilterOriginCategoryService;
import com.personal.business.origincategory.notifications.OriginCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OriginCategoryServiceFactory {

    private static final String TABLE_NAME = "origin_categories";

    public static CreateService CreateOriginCategory(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OriginCategoryNotificationFactory.CreateOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.CreateOriginCategoryFail())
                .build();
    }

    public static FilterOriginCategoryService FilterOriginCategory(String dbClient) {

        return new FilterOriginCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditOriginCategory(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OriginCategoryNotificationFactory.UpdateOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.UpdateOriginCategoryFail())
                .build();
    }

    public static DeleteService DeleteOriginCategory(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OriginCategoryNotificationFactory.DeleteOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.DeleteOriginCategoryFail())
                .build();
    }

}
