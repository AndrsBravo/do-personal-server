package com.personal.shared.factories;

import java.util.Optional;

import com.personal.shared.notifications.Notification;

import io.helidon.dbclient.DbClient;

public abstract class ServiceBuilder<T extends ServiceBase> {

    protected final T instance;

    public ServiceBuilder(T instance) {
        this.instance = instance;
    }

    public ServiceBuilder<T> withDbClient(Optional<DbClient> dbClient) {
        this.instance.setDbClient(dbClient);
        return this;
    }

    public ServiceBuilder<T> withTableName(String tableName) {
        this.instance.setTableName(tableName);
        return this;
    }

    public ServiceBuilder<T> withSuccessNotification(Notification successNotification) {
        this.instance.setSuccessNotification(successNotification);
        return this;
    }

    public ServiceBuilder<T> withFailureNotification(Notification failureNotification) {
        this.instance.setFailureNotification(failureNotification);
        return this;
    }

    public T build() {

        return this.instance;
    }
}
