package com.personal.backoffice.commercial.entity.create.services;

import java.util.Optional;

import com.personal.backoffice.commercial.entity.entities.CommercialEntity;
import com.personal.backoffice.commercial.entity.factories.CommercialEntityResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateCommercialEntityService implements ICreateService<CommercialEntity> {

    private final Optional<DbClient> dbClient;

    public CreateCommercialEntityService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<CommercialEntity> create(Query query) {
        if (dbClient.isEmpty()) {
            return CommercialEntityResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("commercial_entities").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {

            return CommercialEntityResultFactory.CreateFail();
        }

        if (result == 0) {
            return CommercialEntityResultFactory.CreateFail();
        }

        return CommercialEntityResultFactory.CreateSuccess(new CommercialEntity());

    }

}
