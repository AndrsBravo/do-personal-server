package com.personal.backoffice.commercial.plandetail.factories;

import com.personal.backoffice.commercial.plandetail.filter.services.FilterCommercialPlanDetailService;
import com.personal.backoffice.commercial.plandetail.notifications.CommercialPlanDetailNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class CommercialPlanDetailServiceFactory {

    private static final String TABLE_NAME = "commercial_plan_details";

    public static CreateService CreateCommercialPlanDetail() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanDetailNotificationFactory.CreateCommercialPlanDetailSuccess())
                .withFailureNotification(CommercialPlanDetailNotificationFactory.CreateCommercialPlanDetailFail())
                .build();
    }

    public static FilterCommercialPlanDetailService FilterCommercialPlanDetail() {

        return new FilterCommercialPlanDetailService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditCommercialPlanDetail() {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanDetailNotificationFactory.UpdateCommercialPlanDetailSuccess())
                .withFailureNotification(CommercialPlanDetailNotificationFactory.UpdateCommercialPlanDetailFail())
                .build();
    }

    public static DeleteService DeleteCommercialPlanDetail() {
        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialPlanDetailNotificationFactory.DeleteCommercialPlanDetailSuccess())
                .withFailureNotification(CommercialPlanDetailNotificationFactory.DeleteCommercialPlanDetailFail())
                .build();
    }

}
