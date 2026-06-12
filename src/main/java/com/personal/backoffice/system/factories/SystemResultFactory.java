package com.personal.backoffice.system.factories;

import com.personal.backoffice.system.entities.DataBase;
import com.personal.backoffice.system.notifications.SystemNotificationsFactory;
import com.personal.shared.services.ServiceResult;

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
