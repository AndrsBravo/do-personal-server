package com.personal.business.deductioncategory.factories;

import com.personal.business.deductioncategory.filter.services.FilterDeductionCategoryService;
import com.personal.business.deductioncategory.notifications.DeductionCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionCategoryServiceFactory {

    private static final String TABLE_NAME = "deductions_categories";

    public static CreateService CreateDeductionCategory(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionCategoryNotificationFactory.CreateDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.CreateDeductionCategoryFail())
                .build();
    }

    public static FilterDeductionCategoryService FilterDeductionCategory(String dbClient) {

        return new FilterDeductionCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditDeductionCategory(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionCategoryNotificationFactory.UpdateDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.UpdateDeductionCategoryFail())
                .build();
    }

    public static DeleteService DeleteDeductionCategory(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionCategoryNotificationFactory.DeleteDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.DeleteDeductionCategoryFail())
                .build();
    }

}
