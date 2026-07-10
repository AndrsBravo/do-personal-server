package com.personal.business.payrollbenefit.factories;

import com.personal.business.payrollbenefit.filter.services.FilterPayrollBenefitService;
import com.personal.business.payrollbenefit.notifications.PayrollBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollBenefitServiceFactory {

    private static final String TABLE_NAME = "payroll_benefits";

    public static CreateService CreatePayrollBenefit(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollBenefitNotificationFactory.CreatePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.CreatePayrollBenefitFail())
                .build();
    }

    public static FilterPayrollBenefitService FilterPayrollBenefit(String dbClient) {

        return new FilterPayrollBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollBenefit(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollBenefitNotificationFactory.UpdatePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.UpdatePayrollBenefitFail())
                .build();
    }

    public static DeleteService DeletePayrollBenefit(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollBenefitNotificationFactory.DeletePayrollBenefitSuccess())
                .withFailureNotification(PayrollBenefitNotificationFactory.DeletePayrollBenefitFail())
                .build();
    }

}
