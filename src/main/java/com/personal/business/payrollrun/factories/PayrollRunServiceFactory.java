package com.personal.business.payrollrun.factories;

import com.personal.business.payrollrun.filter.services.FilterPayrollRunService;
import com.personal.business.payrollrun.notifications.PayrollRunNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunServiceFactory {

    private static final String TABLE_NAME = "payroll_runs";

    public static CreateService CreatePayrollRun(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunNotificationFactory.CreatePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.CreatePayrollRunFail())
                .build();
    }

    public static FilterPayrollRunService FilterPayrollRun(String dbClient) {

        return new FilterPayrollRunService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollRun(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunNotificationFactory.UpdatePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.UpdatePayrollRunFail())
                .build();
    }

    public static DeleteService DeletePayrollRun(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunNotificationFactory.DeletePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.DeletePayrollRunFail())
                .build();
    }

}
