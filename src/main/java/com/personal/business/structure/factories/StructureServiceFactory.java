package com.personal.business.structure.factories;

import com.personal.business.structure.filter.services.FilterStructureService;
import com.personal.business.structure.notifications.StructureNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class StructureServiceFactory {

    private static final String TABLE_NAME = "business_structures";

    public static CreateService CreateStructure(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(StructureNotificationFactory.CreateStructureSuccess())
                .withFailureNotification(StructureNotificationFactory.CreateStructureFail())
                .build();
    }

    public static FilterStructureService FilterStructure(String dbClient) {

        return new FilterStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditStructure(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(StructureNotificationFactory.UpdateStructureSuccess())
                .withFailureNotification(StructureNotificationFactory.UpdateStructureFail())
                .build();
    }

    public static DeleteService DeleteStructure(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(StructureNotificationFactory.DeleteStructureSuccess())
                .withFailureNotification(StructureNotificationFactory.DeleteStructureFail())
                .build();
    }

}
