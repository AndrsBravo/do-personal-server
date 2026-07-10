package com.personal.business.payrollcalculationresult.factories;

import com.personal.business.payrollcalculationresult.filter.services.FilterPayrollCalculationResultService;
import com.personal.business.payrollcalculationresult.notifications.PayrollCalculationResultNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollCalculationResultServiceFactory {

    private static final String TABLE_NAME = "payroll_calculations_results";

    public static CreateService CreatePayrollCalculationResult(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationResultNotificationFactory.CreatePayrollCalculationResultSuccess())
                .withFailureNotification(PayrollCalculationResultNotificationFactory.CreatePayrollCalculationResultFail())
                .build();
    }

    public static FilterPayrollCalculationResultService FilterPayrollCalculationResult(String dbClient) {

        return new FilterPayrollCalculationResultService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditPayrollCalculationResult(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationResultNotificationFactory.UpdatePayrollCalculationResultSuccess())
                .withFailureNotification(PayrollCalculationResultNotificationFactory.UpdatePayrollCalculationResultFail())
                .build();
    }

    public static DeleteService DeletePayrollCalculationResult(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(PayrollCalculationResultNotificationFactory.DeletePayrollCalculationResultSuccess())
                .withFailureNotification(PayrollCalculationResultNotificationFactory.DeletePayrollCalculationResultFail())
                .build();
    }

}
