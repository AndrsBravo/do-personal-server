package com.personal.backoffice.commercial.plan.factories;

import com.personal.backoffice.commercial.plan.filter.services.FilterCommercialPlanService;
import com.personal.backoffice.commercial.plan.notifications.CommercialPlanNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class CommercialPlanServiceFactory {

    private static final String TABLE_NAME = "commercial_plan";

    public static CreateService CreateCommercialPlan() {

        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanNotificationFactory.CreateCommercialPlanSuccess())
                .withFailureNotification(CommercialPlanNotificationFactory.CreateCommercialPlanFail())
                .build();
    }

    public static FilterCommercialPlanService FilterCommercialPlan() {

        return new FilterCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditCommercialPlan() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanNotificationFactory.UpdateCommercialPlanSuccess())
                .withFailureNotification(CommercialPlanNotificationFactory.UpdateCommercialPlanFail())
                .build();
    }

    public static DeleteService DeleteCommercialPlan() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanNotificationFactory.DeleteCommercialPlanSuccess())
                .withFailureNotification(CommercialPlanNotificationFactory.DeleteCommercialPlanFail())
                .build();
    }

}
