package com.personal.business.employee.factories;

import com.personal.business.employee.filter.services.FilterEmployeeService;
import com.personal.business.employee.notifications.EmployeeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeServiceFactory {

    private static final String TABLE_NAME = "employees";

    public static CreateService CreateEmployee(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeNotificationFactory.CreateEmployeeSuccess())
                .withFailureNotification(EmployeeNotificationFactory.CreateEmployeeFail())
                .build();
    }

    public static FilterEmployeeService FilterEmployee(String dbClient) {

        return new FilterEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployee(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeNotificationFactory.UpdateEmployeeSuccess())
                .withFailureNotification(EmployeeNotificationFactory.UpdateEmployeeFail())
                .build();
    }

    public static DeleteService DeleteEmployee(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeNotificationFactory.DeleteEmployeeSuccess())
                .withFailureNotification(EmployeeNotificationFactory.DeleteEmployeeFail())
                .build();
    }

}
