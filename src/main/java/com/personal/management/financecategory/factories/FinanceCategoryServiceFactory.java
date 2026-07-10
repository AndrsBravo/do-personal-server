package com.personal.management.financecategory.factories;

import com.personal.management.financecategory.filter.services.FilterFinanceCategoryService;
import com.personal.management.financecategory.notifications.FinanceCategoryNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class FinanceCategoryServiceFactory {

    private static final String TABLE_NAME = "finance_categories";

    public static CreateService CreateFinanceCategory() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(FinanceCategoryNotificationFactory.CreateFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.CreateFinanceCategoryFail())
                .build();
    }

    public static FilterFinanceCategoryService FilterFinanceCategory() {

        return new FilterFinanceCategoryService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditFinanceCategory() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.UpdateFinanceCategoryFail())
                .build();
    }

    public static DeleteService DeleteFinanceCategory() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(FinanceCategoryNotificationFactory.DeleteFinanceCategorySuccess())
                .withFailureNotification(FinanceCategoryNotificationFactory.DeleteFinanceCategoryFail())
                .build();
    }

}
