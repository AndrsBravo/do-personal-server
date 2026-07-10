package com.personal.management.payrollbenefit.factories;

import com.personal.management.payrollbenefit.filter.services.FilterPayrollBenefitService;
import com.personal.management.payrollbenefit.notifications.PayrollBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollBenefitServiceFactory {

    private static final String TABLE_NAME = "payroll_benefits";

    public static CreateService CreatePayrollBenefit() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollBenefitNotificationFactory.CreatePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.CreatePayrollBenefitFail())
                .build();
    }

    public static FilterPayrollBenefitService FilterPayrollBenefit() {

        return new FilterPayrollBenefitService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollBenefit() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollBenefitNotificationFactory.UpdatePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.UpdatePayrollBenefitFail())
                .build();
    }

    public static DeleteService DeletePayrollBenefit() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollBenefitNotificationFactory.DeletePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.DeletePayrollBenefitFail())
                .build();
    }

}
