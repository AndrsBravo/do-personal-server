package com.personal.business.payrolldeduction.factories;

import com.personal.business.payrolldeduction.filter.services.FilterPayrollDeductionService;
import com.personal.business.payrolldeduction.notifications.PayrollDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollDeductionServiceFactory {

    private static final String TABLE_NAME = "payroll_deductions";

    public static CreateService CreatePayrollDeduction(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollDeductionNotificationFactory.CreatePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.CreatePayrollDeductionFail())
                .build();
    }

    public static FilterPayrollDeductionService FilterPayrollDeduction(String dbClient) {

        return new FilterPayrollDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollDeduction(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollDeductionNotificationFactory.UpdatePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.UpdatePayrollDeductionFail())
                .build();
    }

    public static DeleteService DeletePayrollDeduction(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollDeductionNotificationFactory.DeletePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.DeletePayrollDeductionFail())
                .build();
    }

}
