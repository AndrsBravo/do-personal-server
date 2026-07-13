package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.shared.notifications.Notification;
import com.personal.shared.query.Query;
import com.personal.shared.services.GetService;
import com.personal.shared.services.entities.GetResult;

import io.helidon.dbclient.DbClient;

public class ExistsDataBaseService extends GetService<Long> {

    public ExistsDataBaseService(Optional<DbClient> dbClient) {
        super(dbClient);
    }

    @Override
    public GetResult<Long> get(Query query) {

        if (!dbClient.isPresent()) {
            return builder.NotAvailable();
        }

        var sqlQuery = "SELECT name FROM sys.databases  WHERE name = :name";
        try {

            var result = dbClient.get().execute().createGet(sqlQuery).params(query.getParams()).execute();
            System.out.println("Resultado de la consulta: " + query.getParams());
            System.out.println(result);

            builder.withResult(result.stream().count())
                    .withNotification(new Notification("La base de datos se consulto satisfactoriamente"));

        } catch (Exception e) {
            builder.withException(e).withNotification(new Notification("Se ha generado un error consultando la base de datos."));
        }

        return builder.get();
    }

}
