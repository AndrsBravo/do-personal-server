package com.personal.management.payrolldeduction.factories;

import com.personal.management.payrolldeduction.filter.services.FilterPayrollDeductionService;
import com.personal.management.payrolldeduction.notifications.PayrollDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollDeductionServiceFactory {

    private static final String TABLE_NAME = "payroll_deductions";

    public static CreateService CreatePayrollDeduction() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollDeductionNotificationFactory.CreatePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.CreatePayrollDeductionFail())
                .build();
    }

    public static FilterPayrollDeductionService FilterPayrollDeduction() {

        return new FilterPayrollDeductionService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollDeduction() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollDeductionNotificationFactory.UpdatePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.UpdatePayrollDeductionFail())
                .build();
    }

    public static DeleteService DeletePayrollDeduction() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollDeductionNotificationFactory.DeletePayrollDeductionSuccess())
                .withFailureNotification(PayrollDeductionNotificationFactory.DeletePayrollDeductionFail())
                .build();
    }

}
