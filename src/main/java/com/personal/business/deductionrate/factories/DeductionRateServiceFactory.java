package com.personal.business.deductionrate.factories;

import com.personal.business.deductionrate.filter.services.FilterDeductionRateService;
import com.personal.business.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionRateServiceFactory {

    private static final String TABLE_NAME = "business_deductions_rates";

    public static CreateService CreateDeductionRate(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionRateNotificationFactory.CreateDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.CreateDeductionRateFail())
                .build();
    }

    public static FilterDeductionRateService FilterDeductionRate(String dbClient) {

        return new FilterDeductionRateService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditDeductionRate(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionRateNotificationFactory.UpdateDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.UpdateDeductionRateFail())
                .build();
    }

    public static DeleteService DeleteDeductionRate(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionRateNotificationFactory.DeleteDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.DeleteDeductionRateFail())
                .build();
    }

}
