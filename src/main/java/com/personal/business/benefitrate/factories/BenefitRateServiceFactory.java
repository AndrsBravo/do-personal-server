package com.personal.business.benefitrate.factories;

import com.personal.business.benefitrate.filter.services.FilterBenefitRateService;
import com.personal.business.benefitrate.notifications.BenefitRateNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitRateServiceFactory {

    private static final String TABLE_NAME = "business_benefits_rates";

    public static CreateService CreateBenefitRate(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitRateNotificationFactory.CreateBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.CreateBenefitRateFail())
                .build();
    }

    public static FilterBenefitRateService FilterBenefitRate(String dbClient) {

        return new FilterBenefitRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditBenefitRate(String dbClient) {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitRateNotificationFactory.UpdateBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.UpdateBenefitRateFail())
                .build();
    }

    public static DeleteService DeleteBenefitRate(String dbClient) {
        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(BenefitRateNotificationFactory.DeleteBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.DeleteBenefitRateFail())
                .build();
    }

}
