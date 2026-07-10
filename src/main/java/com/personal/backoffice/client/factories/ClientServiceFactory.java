package com.personal.backoffice.client.factories;

import com.personal.backoffice.client.commercialplan.add.services.AddClientCommercialPlanService;
import com.personal.backoffice.client.commercialplan.filter.services.FilterClientCommercialPlanService;
import com.personal.backoffice.client.filter.services.FilterClientService;
import com.personal.backoffice.client.notifications.ClientNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class ClientServiceFactory {

    private static final String TABLE_NAME = "clients";

    public static CreateService CreateClient() {

        return CreateServiceBuilder
                .builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientNotificationFactory.CreateClientSuccess())
                .withFailureNotification(ClientNotificationFactory.CreateClientFail())
                .build();
    }

    public static FilterClientService FilterClients() {

        return new FilterClientService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditClient() {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientNotificationFactory.UpdateClientSuccess())
                .withFailureNotification(ClientNotificationFactory.UpdateClientFail())
                .build();
    }

    public static DeleteService DeleteClient() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(ClientNotificationFactory.DeleteClientSuccess())
                .withFailureNotification(ClientNotificationFactory.DeleteClientFail())
                .build();
    }

    public static AddClientCommercialPlanService AddClientCommercialPlan() {

        return new AddClientCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }

    public static FilterClientCommercialPlanService FilterClientCommercialPlan() {

        return new FilterClientCommercialPlanService(DbClientMSSQLFactory.SystemMaster());
    }
}
