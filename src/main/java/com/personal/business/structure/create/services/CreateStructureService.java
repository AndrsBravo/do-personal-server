package com.personal.business.structure.create.services;

import java.util.Optional;

import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.factories.StructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateStructureService implements ICreateService<Structure> {

    private final Optional<DbClient> dbClient;

    public CreateStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<Structure> create(Query query) {
        if (dbClient.isEmpty()) {
            return StructureResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("business_structures").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return StructureResultFactory.CreateFail();
        }

        if (result == 0) {
            return StructureResultFactory.CreateFail();
        }

        return StructureResultFactory.CreateSuccess(new Structure());

    }

}
