package com.personal.business.payrollcalculation.factories;

import com.personal.business.payrollcalculation.filter.services.FilterPayrollCalculationService;
import com.personal.business.payrollcalculation.notifications.PayrollCalculationNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollCalculationServiceFactory {

    private static final String TABLE_NAME = "payroll_calculations";

    public static CreateService CreatePayrollCalculation(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationNotificationFactory.CreatePayrollCalculationSuccess())
                .withFailureNotification(PayrollCalculationNotificationFactory.CreatePayrollCalculationFail())
                .build();
    }

    public static FilterPayrollCalculationService FilterPayrollCalculation(String dbClient) {

        return new FilterPayrollCalculationService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollCalculation(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationNotificationFactory.UpdatePayrollCalculationSuccess())
                .withFailureNotification(PayrollCalculationNotificationFactory.UpdatePayrollCalculationFail())
                .build();
    }

    public static DeleteService DeletePayrollCalculation(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationNotificationFactory.DeletePayrollCalculationSuccess())
                .withFailureNotification(PayrollCalculationNotificationFactory.DeletePayrollCalculationFail())
                .build();
    }

}
