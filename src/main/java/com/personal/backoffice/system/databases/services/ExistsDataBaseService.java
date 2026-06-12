package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.shared.notifications.Notification;
import com.personal.shared.query.Query;
import com.personal.shared.services.IGetService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class ExistsDataBaseService implements IGetService<Long> {

    private final Optional<DbClient> dbClient;

    public ExistsDataBaseService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Long> get(Query query) {

        if (!dbClient.isPresent()) {
            return new ServiceResult<>(new Notification("No database connection available"), -1L);
        }

        var sqlQuery = "SELECT name FROM sys.databases  WHERE name = :name";
        var result = dbClient.get().execute().createGet(sqlQuery).params(query.getParams()).execute();
        System.out.println("Resultado de la consulta: " + query.getParams());
        System.out.println(result);
        return new ServiceResult<>(null, result.stream().count());
    }

}
