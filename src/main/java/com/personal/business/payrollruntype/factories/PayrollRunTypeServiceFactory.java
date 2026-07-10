package com.personal.business.payrollruntype.factories;

import com.personal.business.payrollruntype.filter.services.FilterPayrollRunTypeService;
import com.personal.business.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunTypeServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_types";

    public static CreateService CreatePayrollRunType(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunTypeNotificationFactory.CreatePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.CreatePayrollRunTypeFail())
                .build();
    }

    public static FilterPayrollRunTypeService FilterPayrollRunType(String dbConnection) {

        return new FilterPayrollRunTypeService(DbClientMSSQLFactory.DbClient(dbConnection));
    }

    public static UpdateService EditPayrollRunType(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeFail())
                .build();
    }

    public static DeleteService DeletePayrollRunType(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeFail())
                .build();
    }

}
