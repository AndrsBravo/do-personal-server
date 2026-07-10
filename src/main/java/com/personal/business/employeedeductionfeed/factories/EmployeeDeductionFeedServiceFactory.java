package com.personal.business.employeedeductionfeed.factories;

import com.personal.business.employeedeductionfeed.filter.services.FilterEmployeeDeductionFeedService;
import com.personal.business.employeedeductionfeed.notifications.EmployeeDeductionFeedNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeDeductionFeedServiceFactory {

    private static final String TABLE_NAME = "employee_deductions_feeds";

    public static CreateService CreateEmployeeDeductionFeed(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionFeedNotificationFactory.CreateEmployeeDeductionFeedSuccess())
                .withFailureNotification(EmployeeDeductionFeedNotificationFactory.CreateEmployeeDeductionFeedFail())
                .build();
    }

    public static FilterEmployeeDeductionFeedService FilterEmployeeDeductionFeed(String dbClient) {

        return new FilterEmployeeDeductionFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployeeDeductionFeed(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionFeedNotificationFactory.UpdateEmployeeDeductionFeedSuccess())
                .withFailureNotification(EmployeeDeductionFeedNotificationFactory.UpdateEmployeeDeductionFeedFail())
                .build();
    }

    public static DeleteService DeleteEmployeeDeductionFeed(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionFeedNotificationFactory.DeleteEmployeeDeductionFeedSuccess())
                .withFailureNotification(EmployeeDeductionFeedNotificationFactory.DeleteEmployeeDeductionFeedFail())
                .build();
    }

}
