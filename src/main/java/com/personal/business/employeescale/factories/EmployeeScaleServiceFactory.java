package com.personal.business.employeescale.factories;

import com.personal.business.employeescale.filter.services.FilterEmployeeScaleService;
import com.personal.business.employeescale.notifications.EmployeeScaleNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeScaleServiceFactory {

    private static final String TABLE_NAME = "employee_scale";

    public static CreateService CreateEmployeeScale(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeScaleNotificationFactory.CreateEmployeeScaleSuccess())
                .withFailureNotification(EmployeeScaleNotificationFactory.CreateEmployeeScaleFail())
                .build();
    }

    public static FilterEmployeeScaleService FilterEmployeeScale(String dbClient) {

        return new FilterEmployeeScaleService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployeeScale(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeScaleNotificationFactory.UpdateEmployeeScaleSuccess())
                .withFailureNotification(EmployeeScaleNotificationFactory.UpdateEmployeeScaleFail())
                .build();
    }

    public static DeleteService DeleteEmployeeScale(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeScaleNotificationFactory.DeleteEmployeeScaleSuccess())
                .withFailureNotification(EmployeeScaleNotificationFactory.DeleteEmployeeScaleFail())
                .build();
    }

}
