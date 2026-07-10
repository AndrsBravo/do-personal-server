package com.personal.management.benefit.factories;

import com.personal.management.benefit.filter.services.FilterBenefitService;
import com.personal.management.benefit.notifications.BenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BenefitServiceFactory {

    private static final String TABLE_NAME = "business_benefits";

    public static CreateService CreateBenefit() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitNotificationFactory.CreateBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.CreateBenefitFail())
                .build();
    }

    public static FilterBenefitService FilterBenefit() {

        return new FilterBenefitService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditBenefit() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitNotificationFactory.UpdateBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.UpdateBenefitFail())
                .build();
    }

    public static DeleteService DeleteBenefit() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(BenefitNotificationFactory.DeleteBenefitSuccess())
                .withFailureNotification(BenefitNotificationFactory.DeleteBenefitFail())
                .build();
    }

}
