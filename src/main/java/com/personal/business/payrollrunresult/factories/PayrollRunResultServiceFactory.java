package com.personal.business.payrollrunresult.factories;

import com.personal.business.payrollrunresult.filter.services.FilterPayrollRunResultService;
import com.personal.business.payrollrunresult.notifications.PayrollRunResultNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunResultServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_results";

    public static CreateService CreatePayrollRunResult(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunResultNotificationFactory.CreatePayrollRunResultSuccess())
                .withFailureNotification(PayrollRunResultNotificationFactory.CreatePayrollRunResultFail())
                .build();
    }

    public static FilterPayrollRunResultService FilterPayrollRunResult(String dbClient) {

        return new FilterPayrollRunResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollRunResult(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunResultNotificationFactory.UpdatePayrollRunResultSuccess())
                .withFailureNotification(PayrollRunResultNotificationFactory.UpdatePayrollRunResultFail())
                .build();
    }

    public static DeleteService DeletePayrollRunResult(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunResultNotificationFactory.DeletePayrollRunResultSuccess())
                .withFailureNotification(PayrollRunResultNotificationFactory.DeletePayrollRunResultFail())
                .build();
    }

}
