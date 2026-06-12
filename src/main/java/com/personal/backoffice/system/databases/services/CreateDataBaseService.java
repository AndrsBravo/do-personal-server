package com.personal.backoffice.system.databases.services;

import java.util.Optional;

import com.personal.backoffice.system.entities.DataBase;
import com.personal.backoffice.system.factories.SystemResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateDataBaseService implements ICreateService<DataBase> {

    private final Optional<DbClient> dbClient;

    public CreateDataBaseService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<DataBase> create(Query query) {

        //If not connection with db
        if (!dbClient.isPresent()) {
            return SystemResultFactory.CreateDataBaseFail();
        }

        var createDataBaseQuery = "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = '" + query.getParams().get("name") + "') BEGIN CREATE DATABASE " + query.getParams().get("name") + " END;";

        System.out.println("Query: " + createDataBaseQuery);
        System.out.println("Params: " + query.getParams());
        var result = dbClient.get().execute().dml(createDataBaseQuery);

        if (result > 0) {
            return SystemResultFactory.DataBaseCreated(new DataBase(query.getParams().get("name")));
        }

        return SystemResultFactory.CreateDataBaseFail();

    }

}
