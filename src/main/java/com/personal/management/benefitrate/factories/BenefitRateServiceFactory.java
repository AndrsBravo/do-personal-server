package com.personal.management.benefitrate.factories;

import com.personal.management.benefitrate.filter.services.FilterBenefitRateService;
import com.personal.management.benefitrate.notifications.BenefitRateNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitRateServiceFactory {

    private static final String TABLE_NAME = "business_benefits_rates";

    public static CreateService CreateBenefitRate() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitRateNotificationFactory.CreateBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.CreateBenefitRateFail())
                .build();
    }

    public static FilterBenefitRateService FilterBenefitRate() {

        return new FilterBenefitRateService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditBenefitRate() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitRateNotificationFactory.UpdateBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.UpdateBenefitRateFail())
                .build();
    }

    public static DeleteService DeleteBenefitRate() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitRateNotificationFactory.DeleteBenefitRateSuccess())
                .withFailureNotification(BenefitRateNotificationFactory.DeleteBenefitRateFail())
                .build();
    }

}
