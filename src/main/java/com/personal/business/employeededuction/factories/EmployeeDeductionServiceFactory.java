package com.personal.business.employeededuction.factories;

import com.personal.business.employeededuction.filter.services.FilterEmployeeDeductionService;
import com.personal.business.employeededuction.notifications.EmployeeDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeDeductionServiceFactory {

    private static final String TABLE_NAME = "employee_deductions";

    public static CreateService CreateEmployeeDeduction(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionNotificationFactory.CreateEmployeeDeductionSuccess())
                .withFailureNotification(EmployeeDeductionNotificationFactory.CreateEmployeeDeductionFail())
                .build();
    }

    public static FilterEmployeeDeductionService FilterEmployeeDeduction(String dbClient) {

        return new FilterEmployeeDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployeeDeduction(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionNotificationFactory.UpdateEmployeeDeductionSuccess())
                .withFailureNotification(EmployeeDeductionNotificationFactory.UpdateEmployeeDeductionFail())
                .build();
    }

    public static DeleteService DeleteEmployeeDeduction(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeDeductionNotificationFactory.DeleteEmployeeDeductionSuccess())
                .withFailureNotification(EmployeeDeductionNotificationFactory.DeleteEmployeeDeductionFail())
                .build();
    }

}
