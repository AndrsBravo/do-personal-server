package com.personal.management.payroll.factories;

import com.personal.management.payroll.filter.services.FilterPayrollService;
import com.personal.management.payroll.notifications.PayrollNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollServiceFactory {

    private static final String TABLE_NAME = "payrolls";

    public static CreateService CreatePayroll() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollNotificationFactory.CreatePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.CreatePayrollFail())
                .build();
    }

    public static FilterPayrollService FilterPayroll() {

        return new FilterPayrollService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayroll() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollNotificationFactory.UpdatePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.UpdatePayrollFail())
                .build();
    }

    public static DeleteService DeletePayroll() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollNotificationFactory.DeletePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.DeletePayrollFail())
                .build();
    }

}
