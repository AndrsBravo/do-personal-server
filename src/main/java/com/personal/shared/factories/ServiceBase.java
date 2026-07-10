package com.personal.shared.factories;

import java.util.Optional;

import com.personal.shared.notifications.Notification;

import io.helidon.dbclient.DbClient;

public abstract class ServiceBase {

    protected String tableName;
    protected Optional<DbClient> dbClient;
    protected Notification successNotification;
    protected Notification failureNotification;

    public void setDbClient(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setSuccessNotification(Notification successNotification) {
        this.successNotification = successNotification;
    }

    public void setFailureNotification(Notification failureNotification) {
        this.failureNotification = failureNotification;
    }
}
