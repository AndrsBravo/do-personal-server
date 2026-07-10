package com.personal.management.deduction.factories;

import com.personal.management.deduction.filter.services.FilterDeductionService;
import com.personal.management.deduction.notifications.DeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionServiceFactory {

    private static final String TABLE_NAME = "business_deductions";

    public static CreateService CreateDeduction() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionNotificationFactory.CreateDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.CreateDeductionFail())
                .build();
    }

    public static FilterDeductionService FilterDeduction() {

        return new FilterDeductionService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditDeduction() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionNotificationFactory.UpdateDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.UpdateDeductionFail())
                .build();
    }

    public static DeleteService DeleteDeduction() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(DeductionNotificationFactory.DeleteDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.DeleteDeductionFail())
                .build();
    }

}
