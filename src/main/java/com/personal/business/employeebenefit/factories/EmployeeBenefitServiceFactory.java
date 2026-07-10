package com.personal.business.employeebenefit.factories;

import com.personal.business.employeebenefit.filter.services.FilterEmployeeBenefitService;
import com.personal.business.employeebenefit.notifications.EmployeeBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class EmployeeBenefitServiceFactory {

    private static final String TABLE_NAME = "employee_benefits";

    public static CreateService CreateEmployeeBenefit(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitNotificationFactory.CreateEmployeeBenefitSuccess())
                .withFailureNotification(EmployeeBenefitNotificationFactory.CreateEmployeeBenefitFail())
                .build();
    }

    public static FilterEmployeeBenefitService FilterEmployeeBenefit(String dbClient) {

        return new FilterEmployeeBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditEmployeeBenefit(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitNotificationFactory.UpdateEmployeeBenefitSuccess())
                .withFailureNotification(EmployeeBenefitNotificationFactory.UpdateEmployeeBenefitFail())
                .build();
    }

    public static DeleteService DeleteEmployeeBenefit(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(EmployeeBenefitNotificationFactory.DeleteEmployeeBenefitSuccess())
                .withFailureNotification(EmployeeBenefitNotificationFactory.DeleteEmployeeBenefitFail())
                .build();
    }

}
