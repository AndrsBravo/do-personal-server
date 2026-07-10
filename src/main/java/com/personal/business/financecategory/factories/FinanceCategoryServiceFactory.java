package com.personal.business.financecategory.factories;

import com.personal.business.financecategory.filter.services.FilterFinanceCategoryService;
import com.personal.business.financecategory.notifications.FinanceCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class FinanceCategoryServiceFactory {

    private static final String TABLE_NAME = "finance_categories";

    public static CreateService CreateFinanceCategory(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(FinanceCategoryNotificationFactory.CreateFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.CreateFinanceCategoryFail())
                .build();
    }

    public static FilterFinanceCategoryService FilterFinanceCategory(String dbClient) {

        return new FilterFinanceCategoryService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditFinanceCategory(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategoryFail())
                .build();
    }

    public static DeleteService DeleteFinanceCategory(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(FinanceCategoryNotificationFactory.DeleteFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.DeleteFinanceCategoryFail())
                .build();
    }

}
