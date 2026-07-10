package com.personal.management.payrollrunbenefit.factories;

import com.personal.management.payrollrunbenefit.filter.services.FilterPayrollRunBenefitService;
import com.personal.management.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunBenefitServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_benefits";

    public static CreateService CreatePayrollRunBenefit() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.CreatePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.CreatePayrollRunBenefitFail())
                .build();
    }

    public static FilterPayrollRunBenefitService FilterPayrollRunBenefit() {

        return new FilterPayrollRunBenefitService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollRunBenefit() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitFail())
                .build();
    }

    public static DeleteService DeletePayrollRunBenefit() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitFail())
                .build();
    }

}
