package com.personal.business.payroll.factories;

import com.personal.business.payroll.filter.services.FilterPayrollService;
import com.personal.business.payroll.notifications.PayrollNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollServiceFactory {

    private static final String TABLE_NAME = "payrolls";

    public static CreateService CreatePayroll(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollNotificationFactory.CreatePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.CreatePayrollFail())
                .build();
    }

    public static FilterPayrollService FilterPayroll(String dbClient) {

        return new FilterPayrollService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayroll(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollNotificationFactory.UpdatePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.UpdatePayrollFail())
                .build();
    }

    public static DeleteService DeletePayroll(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollNotificationFactory.DeletePayrollSuccess())
                .withFailureNotification(PayrollNotificationFactory.DeletePayrollFail())
                .build();
    }

}
