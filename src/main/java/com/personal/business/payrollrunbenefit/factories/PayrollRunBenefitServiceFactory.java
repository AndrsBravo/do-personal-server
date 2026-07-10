package com.personal.business.payrollrunbenefit.factories;

import com.personal.business.payrollrunbenefit.filter.services.FilterPayrollRunBenefitService;
import com.personal.business.payrollrunbenefit.notifications.PayrollRunBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunBenefitServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_benefits";

    public static CreateService CreatePayrollRunBenefit(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.CreatePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.CreatePayrollRunBenefitFail())
                .build();
    }

    public static FilterPayrollRunBenefitService FilterPayrollRunBenefit(String dbClient) {

        return new FilterPayrollRunBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollRunBenefit(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.UpdatePayrollRunBenefitFail())
                .build();
    }

    public static DeleteService DeletePayrollRunBenefit(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitSuccess())
                .withFailureNotification(PayrollRunBenefitNotificationFactory.DeletePayrollRunBenefitFail())
                .build();
    }

}
