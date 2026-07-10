package com.personal.backoffice.system.appdata.notifications;

import com.personal.shared.notifications.Notification;

public class SystemNotificationsFactory {

    public static Notification CreateDataBaseFail() {
        return new Notification("Ha ocurrido un error mientras se creaba la base de datos. ");
    }

    public static Notification MigrateDataBaseFail() {
        return new Notification("Ha ocurrido un error mientras se migraba la base de datos. ");
    }

    public static Notification MigrateDataBaseSuccess() {
        return new Notification("La base de datos fue migrada exitosamente.");
    }

    public static Notification CreateDataBaseSuccess() {
        return new Notification("La base de datos fue creada exitosamente.");
    }

}
