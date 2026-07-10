package com.personal.management.deductionrate.factories;

import com.personal.management.deductionrate.filter.services.FilterDeductionRateService;
import com.personal.management.deductionrate.notifications.DeductionRateNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionRateServiceFactory {

    private static final String TABLE_NAME = "business_deductions_rates";

    public static CreateService CreateDeductionRate() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionRateNotificationFactory.CreateDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.CreateDeductionRateFail())
                .build();
    }

    public static FilterDeductionRateService FilterDeductionRate() {

        return new FilterDeductionRateService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditDeductionRate() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionRateNotificationFactory.UpdateDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.UpdateDeductionRateFail())
                .build();
    }

    public static DeleteService DeleteDeductionRate() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionRateNotificationFactory.DeleteDeductionRateSuccess())
                .withFailureNotification(DeductionRateNotificationFactory.DeleteDeductionRateFail())
                .build();
    }

}
