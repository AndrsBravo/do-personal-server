package com.personal.business.deduction.factories;

import com.personal.business.deduction.filter.services.FilterDeductionService;
import com.personal.business.deduction.notifications.DeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class DeductionServiceFactory {

    private static final String TABLE_NAME = "business_deductions";

    public static CreateService CreateDeduction(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionNotificationFactory.CreateDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.CreateDeductionFail())
                .build();
    }

    public static FilterDeductionService FilterDeduction(String dbClient) {

        return new FilterDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditDeduction(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionNotificationFactory.UpdateDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.UpdateDeductionFail())
                .build();
    }

    public static DeleteService DeleteDeduction(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(DeductionNotificationFactory.DeleteDeductionSuccess())
                .withFailureNotification(DeductionNotificationFactory.DeleteDeductionFail())
                .build();
    }

}
