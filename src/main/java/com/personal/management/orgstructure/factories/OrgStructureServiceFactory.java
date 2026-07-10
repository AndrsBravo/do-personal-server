package com.personal.management.orgstructure.factories;

import com.personal.management.orgstructure.filter.services.FilterOrgStructureService;
import com.personal.management.orgstructure.notifications.OrgStructureNotificationFactory;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class OrgStructureServiceFactory {

    private static final String TABLE_NAME = "organization_structures";

    public static CreateService CreateOrgStructure() {
        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgStructureNotificationFactory.CreateOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.CreateOrgStructureFail())
                .build();
    }

    public static FilterOrgStructureService FilterOrgStructure() {

        return new FilterOrgStructureService(DbClientMSSQLFactory.Management());
    }

    public static UpdateService EditOrgStructure() {
        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgStructureNotificationFactory.UpdateOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.UpdateOrgStructureFail())
                .build();
    }

    public static DeleteService DeleteOrgStructure() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.Management())
                .withSuccessNotification(OrgStructureNotificationFactory.DeleteOrgStructureSuccess())
                .withFailureNotification(OrgStructureNotificationFactory.DeleteOrgStructureFail())
                .build();
    }

}
