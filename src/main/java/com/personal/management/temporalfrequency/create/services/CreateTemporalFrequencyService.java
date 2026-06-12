package com.personal.management.temporalfrequency.create.services;

import java.util.Optional;

import com.personal.management.temporalfrequency.entities.TemporalFrequency;
import com.personal.management.temporalfrequency.factories.TemporalFrequencyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.ICreateService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class CreateTemporalFrequencyService implements ICreateService<TemporalFrequency> {

    private final Optional<DbClient> dbClient;

    public CreateTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TemporalFrequency> create(Query query) {
        if (dbClient.isEmpty()) {
            return TemporalFrequencyResultFactory.CreateFail();
        }

        var dbclient = dbClient.get();

        var insertQuery = query.InsertInto("temporal_frequencies").Get();

        //System.out.println(insertQuery);
        long result = 0;

        try {

            result = dbclient.execute()
                    .createInsert(insertQuery)
                    .params(query.getParams())
                    .execute();
        } catch (Exception e) {
            //System.out.println("Hubo una excepción al crear el tipo de usuario " + e.getMessage());
            return TemporalFrequencyResultFactory.CreateFail();
        }

        if (result == 0) {
            return TemporalFrequencyResultFactory.CreateFail();
        }

        return TemporalFrequencyResultFactory.CreateSuccess(new TemporalFrequency());

    }

}
