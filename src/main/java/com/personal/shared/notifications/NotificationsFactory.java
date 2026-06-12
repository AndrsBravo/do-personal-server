package com.personal.shared.notifications;

public class NotificationsFactory {

    public static Notification DbNotAvailable() {
        return new Notification("No fue posible la conexión con la base de datos.");
    }
}
