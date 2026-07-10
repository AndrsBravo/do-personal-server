package com.personal.management.origincategory.factories;

import com.personal.management.origincategory.filter.services.FilterOriginCategoryService;
import com.personal.management.origincategory.notifications.OriginCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OriginCategoryServiceFactory {

    private static final String TABLE_NAME = "origin_categories";

    public static CreateService CreateOriginCategory() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OriginCategoryNotificationFactory.CreateOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.CreateOriginCategoryFail())
                .build();
    }

    public static FilterOriginCategoryService FilterOriginCategory() {

        return new FilterOriginCategoryService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditOriginCategory() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OriginCategoryNotificationFactory.UpdateOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.UpdateOriginCategoryFail())
                .build();
    }

    public static DeleteService DeleteOriginCategory() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OriginCategoryNotificationFactory.DeleteOriginCategorySuccess())
                .withFailureNotification(OriginCategoryNotificationFactory.DeleteOriginCategoryFail())
                .build();
    }

}
