package com.personal.management.payrollrundeduction.factories;

import com.personal.management.payrollrundeduction.filter.services.FilterPayrollRunDeductionService;
import com.personal.management.payrollrundeduction.notifications.PayrollRunDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunDeductionServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_deductions";

    public static CreateService CreatePayrollRunDeduction() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.CreatePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.CreatePayrollRunDeductionFail())
                .build();
    }

    public static FilterPayrollRunDeductionService FilterPayrollRunDeduction() {

        return new FilterPayrollRunDeductionService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollRunDeduction() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.UpdatePayrollRunDeductionFail())
                .build();
    }

    public static DeleteService DeletePayrollRunDeduction() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionSuccess())
                .withFailureNotification(PayrollRunDeductionNotificationFactory.DeletePayrollRunDeductionFail())
                .build();
    }

}
