package com.personal.management.benefitcategory.factories;

import com.personal.management.benefitcategory.filter.services.FilterBenefitCategoryService;
import com.personal.management.benefitcategory.notifications.BenefitCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitCategoryServiceFactory {

    private static final String TABLE_NAME = "benefit_categories";

    public static CreateService CreateBenefitCategory() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitCategoryNotificationFactory.CreateBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.CreateBenefitCategoryFail())
                .build();
    }

    public static FilterBenefitCategoryService FilterBenefitCategory() {

        return new FilterBenefitCategoryService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditBenefitCategory() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategoryFail())
                .build();
    }

    public static DeleteService DeleteBenefitCategory() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitCategoryNotificationFactory.DeleteBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.DeleteBenefitCategoryFail())
                .build();
    }

}
