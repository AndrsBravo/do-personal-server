package com.personal.management.payrollrun.factories;

import com.personal.management.payrollrun.filter.services.FilterPayrollRunService;
import com.personal.management.payrollrun.notifications.PayrollRunNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunServiceFactory {

    private static final String TABLE_NAME = "payroll_runs";

    public static CreateService CreatePayrollRun() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunNotificationFactory.CreatePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.CreatePayrollRunFail())
                .build();
    }

    public static FilterPayrollRunService FilterPayrollRun() {

        return new FilterPayrollRunService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollRun() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunNotificationFactory.UpdatePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.UpdatePayrollRunFail())
                .build();
    }

    public static DeleteService DeletePayrollRun() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunNotificationFactory.DeletePayrollRunSuccess())
                .withFailureNotification(PayrollRunNotificationFactory.DeletePayrollRunFail())
                .build();
    }

}
