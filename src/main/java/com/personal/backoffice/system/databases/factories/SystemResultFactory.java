package com.personal.backoffice.system.databases.factories;

import com.personal.backoffice.system.databases.entities.DataBase;
import com.personal.backoffice.system.databases.notifications.SystemNotificationsFactory;
import com.personal.shared.services.entities.ServiceResult;

public class SystemResultFactory {

    public static ServiceResult<DataBase> DataBaseCreated(DataBase dataBase) {
        return new ServiceResult(null, dataBase);
    }

    public static ServiceResult<DataBase> CreateDataBaseFail() {

        return new ServiceResult(SystemNotificationsFactory.CreateDataBaseFail(), null);

    }

    public static ServiceResult<DataBase> MigrateDataBaseFail(String dbName) {

        return new ServiceResult(SystemNotificationsFactory.MigrateDataBaseFail(dbName), null);

    }
}
