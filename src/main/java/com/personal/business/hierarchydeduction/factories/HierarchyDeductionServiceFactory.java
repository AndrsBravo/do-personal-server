package com.personal.business.hierarchydeduction.factories;

import com.personal.business.hierarchydeduction.filter.services.FilterHierarchyDeductionService;
import com.personal.business.hierarchydeduction.notifications.HierarchyDeductionNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class HierarchyDeductionServiceFactory {

    private static final String TABLE_NAME = "hierarchies_deductions";

    public static CreateService CreateHierarchyDeduction(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionNotificationFactory.CreateHierarchyDeductionSuccess())
                .withFailureNotification(HierarchyDeductionNotificationFactory.CreateHierarchyDeductionFail())
                .build();
    }

    public static FilterHierarchyDeductionService FilterHierarchyDeduction(String dbClient) {

        return new FilterHierarchyDeductionService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditHierarchyDeduction(String dbClient) {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionNotificationFactory.UpdateHierarchyDeductionSuccess())
                .withFailureNotification(HierarchyDeductionNotificationFactory.UpdateHierarchyDeductionFail())
                .build();
    }

    public static DeleteService DeleteHierarchyDeduction(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyDeductionNotificationFactory.DeleteHierarchyDeductionSuccess())
                .withFailureNotification(HierarchyDeductionNotificationFactory.DeleteHierarchyDeductionFail())
                .build();
    }

}
