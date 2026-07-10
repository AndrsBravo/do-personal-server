package com.personal.management.deductioncategory.factories;

import com.personal.management.deductioncategory.filter.services.FilterDeductionCategoryService;
import com.personal.management.deductioncategory.notifications.DeductionCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionCategoryServiceFactory {

    private static final String TABLE_NAME = "deductions_categories";

    public static CreateService CreateDeductionCategory() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionCategoryNotificationFactory.CreateDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.CreateDeductionCategoryFail())
                .build();
    }

    public static FilterDeductionCategoryService FilterDeductionCategory() {

        return new FilterDeductionCategoryService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditDeductionCategory() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionCategoryNotificationFactory.UpdateDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.UpdateDeductionCategoryFail())
                .build();
    }

    public static DeleteService DeleteDeductionCategory() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionCategoryNotificationFactory.DeleteDeductionCategorySuccess())
                .withFailureNotification(DeductionCategoryNotificationFactory.DeleteDeductionCategoryFail())
                .build();
    }

}
