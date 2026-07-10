package com.personal.backoffice.business.factories;

import com.personal.backoffice.business.notifications.BusinessNotificationFactory;
import com.personal.backoffice.business.services.FilterBusinessService;
import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.factories.CreateService;
import com.personal.shared.factories.CreateServiceBuilder;
import com.personal.shared.factories.DeleteService;
import com.personal.shared.factories.DeleteServiceBuilder;
import com.personal.shared.factories.UpdateService;
import com.personal.shared.factories.UpdateServiceBuilder;

public class BusinessServiceFactory {

    private static final String TABLE_NAME = "business";

    public static CreateService CreateBusiness() {

        return CreateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(BusinessNotificationFactory.CreateBusinessSuccess())
                .withFailureNotification(BusinessNotificationFactory.CreateBusinessFail())
                .build();

    }

    public static FilterBusinessService FilterBusiness() {

        return new FilterBusinessService(DbClientMSSQLFactory.SystemMaster());
    }

    public static UpdateService EditBusiness() {

        return UpdateServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(BusinessNotificationFactory.UpdateBusinessSuccess())
                .withFailureNotification(BusinessNotificationFactory.UpdateBusinessFail())
                .build();
    }

    public static DeleteService DeleteBusiness() {

        return DeleteServiceBuilder.builder()
                .withTableName(TABLE_NAME)
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(BusinessNotificationFactory.DeleteBusinessSuccess())
                .withFailureNotification(BusinessNotificationFactory.DeleteBusinessFail())
                .build();
    }

}
