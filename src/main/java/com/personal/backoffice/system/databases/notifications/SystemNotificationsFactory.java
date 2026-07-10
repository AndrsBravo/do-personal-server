package com.personal.backoffice.system.databases.notifications;

import com.personal.shared.notifications.Notification;

public class SystemNotificationsFactory {

    public static Notification CreateDataBaseFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la base de datos. ");
    }

    public static Notification MigrateDataBaseFail(String dbName) {
        return new Notification("Ha ocurrido un error mientras se migraba la base de datos " + dbName + ". ");
    }

    public static Notification CreateDataBaseSuccess() {
        return new Notification("La base de datos fue creada exitosamente.");
    }

}
