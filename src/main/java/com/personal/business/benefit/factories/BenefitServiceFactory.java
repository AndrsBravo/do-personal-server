package com.personal.business.benefit.factories;

import com.personal.business.benefit.filter.services.FilterBenefitService;
import com.personal.business.benefit.notifications.BenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitServiceFactory {

    private static final String TABLE_NAME = "business_benefits";

    public static CreateService CreateBenefit(String dbClient) {
        return CreateServiceBuilder
                .builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitNotificationFactory.CreateBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.CreateBenefitFail())
                .build();
    }

    public static FilterBenefitService FilterBenefit(String dbClient) {

        return new FilterBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditBenefit(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitNotificationFactory.UpdateBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.UpdateBenefitFail())
                .build();
    }

    public static DeleteService DeleteBenefit(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitNotificationFactory.DeleteBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.DeleteBenefitFail())
                .build();
    }

}
