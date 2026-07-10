package com.personal.backoffice.clienttype.factories;

import com.personal.backoffice.clienttype.filter.services.FilterClientTypeService;
import com.personal.backoffice.clienttype.notifications.ClientTypeNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class ClientTypeServiceFactory {

    private static final String TABLE_NAME = "client_types";

    public static CreateService CreateClientType() {

        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientTypeNotificationFactory.CreateClientTypeSuccess())
                .withFailureNotification(ClientTypeNotificationFactory.CreateClientTypeFail())
                .build();
    }

    public static FilterClientTypeService FilterClientTypes() {

        return new FilterClientTypeService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditClientType() {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientTypeNotificationFactory.UpdateClientTypeSuccess())
                .withFailureNotification(ClientTypeNotificationFactory.UpdateClientTypeFail())
                .build();
    }

    public static DeleteService DeleteClientType() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientTypeNotificationFactory.DeleteClientTypeSuccess())
                .withFailureNotification(ClientTypeNotificationFactory.DeleteClientTypeFail())
                .build();
    }

}
