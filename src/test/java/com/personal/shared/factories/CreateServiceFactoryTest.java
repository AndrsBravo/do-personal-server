package com.personal.shared.factories;

import org.junit.Test;

import com.personal.server.dbclient.DbClientMSSQLFactory;
import com.personal.shared.notifications.Notification;

public class CreateServiceFactoryTest {

    public CreateServiceFactoryTest() {
    }

    @Test
    public void testSomeMethod() {

        CreateServiceBuilder
                .builder()
                .withTableName("test")
                .withDbClient(DbClientMSSQLFactory.SystemMaster())
                .withSuccessNotification(new Notification("Success"))
                .withFailureNotification(new Notification("Error"))
                .build();
    }

}
