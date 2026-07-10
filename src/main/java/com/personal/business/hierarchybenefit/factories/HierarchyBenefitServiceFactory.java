package com.personal.business.hierarchybenefit.factories;

import com.personal.business.hierarchybenefit.filter.services.FilterHierarchyBenefitService;
import com.personal.business.hierarchybenefit.notifications.HierarchyBenefitNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class HierarchyBenefitServiceFactory {

    private static final String TABLE_NAME = "hierarchies_benefits";

    public static CreateService CreateHierarchyBenefit(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitNotificationFactory.CreateHierarchyBenefitSuccess())
                .withFailureNotification(HierarchyBenefitNotificationFactory.CreateHierarchyBenefitFail())
                .build();
    }

    public static FilterHierarchyBenefitService FilterHierarchyBenefit(String dbClient) {

        return new FilterHierarchyBenefitService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditHierarchyBenefit(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitNotificationFactory.UpdateHierarchyBenefitSuccess())
                .withFailureNotification(HierarchyBenefitNotificationFactory.UpdateHierarchyBenefitFail())
                .build();
    }

    public static DeleteService DeleteHierarchyBenefit(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(HierarchyBenefitNotificationFactory.DeleteHierarchyBenefitSuccess())
                .withFailureNotification(HierarchyBenefitNotificationFactory.DeleteHierarchyBenefitFail())
                .build();
    }

}
