package com.personal.business.payrollemployee.factories;

import com.personal.business.payrollemployee.filter.services.FilterPayrollEmployeeService;
import com.personal.business.payrollemployee.notifications.PayrollEmployeeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollEmployeeServiceFactory {

    private static final String TABLE_NAME = "payroll_employee";

    public static CreateService CreatePayrollEmployee(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollEmployeeNotificationFactory.CreatePayrollEmployeeSuccess())
                .withFailureNotification(PayrollEmployeeNotificationFactory.CreatePayrollEmployeeFail())
                .build();
    }

    public static FilterPayrollEmployeeService FilterPayrollEmployee(String dbClient) {

        return new FilterPayrollEmployeeService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollEmployee(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollEmployeeNotificationFactory.UpdatePayrollEmployeeSuccess())
                .withFailureNotification(PayrollEmployeeNotificationFactory.UpdatePayrollEmployeeFail())
                .build();
    }

    public static DeleteService DeletePayrollEmployee(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollEmployeeNotificationFactory.DeletePayrollEmployeeSuccess())
                .withFailureNotification(PayrollEmployeeNotificationFactory.DeletePayrollEmployeeFail())
                .build();
    }

}
