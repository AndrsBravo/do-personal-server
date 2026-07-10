package com.personal.business.orgstructure.factories;

import com.personal.business.orgstructure.filter.services.FilterOrgStructureService;
import com.personal.business.orgstructure.notifications.OrgStructureNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgStructureServiceFactory {

    private static final String TABLE_NAME = "organization_structures";

    public static CreateService CreateOrgStructure(String dbClient) {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgStructureNotificationFactory.CreateOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.CreateOrgStructureFail())
                .build();
    }

    public static FilterOrgStructureService FilterOrgStructure(String dbClient) {

        return new FilterOrgStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static UpdateService EditOrgStructure(String dbClient) {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgStructureNotificationFactory.UpdateOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.UpdateOrgStructureFail())
                .build();
    }

    public static DeleteService DeleteOrgStructure(String dbClient) {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.DbClient(dbClient))
                .withSuccessNotification(OrgStructureNotificationFactory.DeleteOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.DeleteOrgStructureFail())
                .build();
    }

}
