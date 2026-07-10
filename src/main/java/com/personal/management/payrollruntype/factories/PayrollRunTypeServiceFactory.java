package com.personal.management.payrollruntype.factories;

import com.personal.management.payrollruntype.filter.services.FilterPayrollRunTypeService;
import com.personal.management.payrollruntype.notifications.PayrollRunTypeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class PayrollRunTypeServiceFactory {

    private static final String TABLE_NAME = "payroll_runs_types";

    public static CreateService CreatePayrollRunType() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunTypeNotificationFactory.CreatePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.CreatePayrollRunTypeFail())
                .build();
    }

    public static FilterPayrollRunTypeService FilterPayrollRunType() {

        return new FilterPayrollRunTypeService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditPayrollRunType() {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.UpdatePayrollRunTypeFail())
                .build();
    }

    public static DeleteService DeletePayrollRunType() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeSuccess())
                .withFailureNotification(PayrollRunTypeNotificationFactory.DeletePayrollRunTypeFail())
                .build();
    }

}
