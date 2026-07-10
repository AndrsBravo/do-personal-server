package com.personal.backoffice.commercial.entity.factories;

import com.personal.backoffice.commercial.entity.filter.services.FilterCommercialEntityService;
import com.personal.backoffice.commercial.entity.notifications.CommercialEntityNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class CommercialEntityServiceFactory {

    private static final String TABLE_NAME = "commercial_entities";

    public static CreateService CreateCommercialEntity() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialEntityNotificationFactory.CreateCommercialEntitySuccess())
                .withFailureNotification(CommercialEntityNotificationFactory.CreateCommercialEntityFail())
                .build();
    }

    public static FilterCommercialEntityService FilterCommercialEntity() {

        return new FilterCommercialEntityService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditCommercialEntity() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialEntityNotificationFactory.UpdateCommercialEntitySuccess())
                .withFailureNotification(CommercialEntityNotificationFactory.UpdateCommercialEntityFail())
                .build();
    }

    public static DeleteService DeleteCommercialEntity() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(CommercialEntityNotificationFactory.DeleteCommercialEntitySuccess())
                .withFailureNotification(CommercialEntityNotificationFactory.DeleteCommercialEntityFail())
                .build();
    }

}
