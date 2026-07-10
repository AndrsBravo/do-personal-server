package com.personal.business.temporalfrequency.delete.services;

import java.util.Optional;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.business.temporalfrequency.factories.TemporalFrequencyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IDeleteService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class DeleteTemporalFrequencyService implements IDeleteService<TemporalFrequency> {

    private final Optional<DbClient> dbClient;

    public DeleteTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TemporalFrequency> delete(Query query) {
        if (dbClient.isEmpty()) {
            return TemporalFrequencyResultFactory.DeleteFail();
        }

        var dbclient = dbClient.get();

        var deleteQuery = query.Delete("temporal_frequencies").Get();

        //System.out.println(deleteQuery);
        long result = 0;

        try {
            result = dbclient.execute()
                    .createDelete(deleteQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {

            return TemporalFrequencyResultFactory.DeleteFail();
        }

        if (result == 0) {
            return TemporalFrequencyResultFactory.DeleteFail();
        }

        return TemporalFrequencyResultFactory.DeleteSuccess(new TemporalFrequency(query.getParams().get("id")));

    }

}
