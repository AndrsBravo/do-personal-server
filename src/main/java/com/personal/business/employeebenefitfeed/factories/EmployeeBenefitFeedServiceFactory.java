package com.personal.business.employeebenefitfeed.factories;

import com.personal.business.employeebenefitfeed.filter.services.FilterEmployeeBenefitFeedService;
import com.personal.business.employeebenefitfeed.notifications.EmployeeBenefitFeedNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeBenefitFeedServiceFactory {

    private static final String TABLE_NAME = "employee_benefits_feeds";

    public static CreateService CreateEmployeeBenefitFeed(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitFeedNotificationFactory.CreateEmployeeBenefitFeedSuccess())
                .withFailureNotification(EmployeeBenefitFeedNotificationFactory.CreateEmployeeBenefitFeedFail())
                .build();
    }

    public static FilterEmployeeBenefitFeedService FilterEmployeeBenefitFeed(String dbClient) {

        return new FilterEmployeeBenefitFeedService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployeeBenefitFeed(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitFeedNotificationFactory.UpdateEmployeeBenefitFeedSuccess())
                .withFailureNotification(EmployeeBenefitFeedNotificationFactory.UpdateEmployeeBenefitFeedFail())
                .build();
    }

    public static DeleteService DeleteEmployeeBenefitFeed(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitFeedNotificationFactory.DeleteEmployeeBenefitFeedSuccess())
                .withFailureNotification(EmployeeBenefitFeedNotificationFactory.DeleteEmployeeBenefitFeedFail())
                .build();
    }

}
