package com.personal.business.benefitcategory.factories;

import com.personal.business.benefitcategory.filter.services.FilterBenefitCategoryService;
import com.personal.business.benefitcategory.notifications.BenefitCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitCategoryServiceFactory {

    private static final String TABLE_NAME = "benefit_categories";

    public static CreateService CreateBenefitCategory(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitCategoryNotificationFactory.CreateBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.CreateBenefitCategoryFail())
                .build();
    }

    public static FilterBenefitCategoryService FilterBenefitCategory(String dbClient) {

        return new FilterBenefitCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditBenefitCategory(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.UpdateBenefitCategoryFail())
                .build();
    }

    public static DeleteService DeleteBenefitCategory(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitCategoryNotificationFactory.DeleteBenefitCategorySuccess())
                .withFailureNotification(BenefitCategoryNotificationFactory.DeleteBenefitCategoryFail())
                .build();
    }

}
