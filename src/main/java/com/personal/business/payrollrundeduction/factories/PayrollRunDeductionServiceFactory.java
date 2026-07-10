package com.personal.business.payrollrundeduction.factories;

import com.personal.business.payrollrundeduction.filter.services.FilterPayrollRunDeductionService;
import com.personal.business.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunDeductionServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_deductions";

    public static CreateService CreatePayrollRunDeduction(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.CreatePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.CreatePayrollRunDeductionFail())
                .build();
    }

    public static FilterPayrollRunDeductionService FilterPayrollRunDeduction(String dbClient) {

        return new FilterPayrollRunDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollRunDeduction(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionFail())
                .build();
    }

    public static DeleteService DeletePayrollRunDeduction(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionFail())
                .build();
    }

}
