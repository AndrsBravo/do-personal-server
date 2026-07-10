package com.personal.business.temporalfrequency.update.services;

import java.util.Optional;

import com.personal.business.temporalfrequency.entities.TemporalFrequency;
import com.personal.business.temporalfrequency.factories.TemporalFrequencyResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IEditService;
import com.personal.shared.services.entities.ServiceResult;

import io.helidon.dbclient.DbClient;

public class EditTemporalFrequencyService implements IEditService<TemporalFrequency> {

    private final Optional<DbClient> dbClient;

    public EditTemporalFrequencyService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<TemporalFrequency> edit(Query query) {

        if (dbClient.isEmpty()) {
            return TemporalFrequencyResultFactory.UpdateFail();
        }

        var dbclient = dbClient.get();

        var updateQuery = query.Update("temporal_frequencies").Get();
        //System.out.println("updateQuery: " + updateQuery);

        long result = 0;
        try {
            result = dbclient.execute()
                    .createUpdate(updateQuery)
                    .params(query.getParams())
                    .execute();

        } catch (Exception e) {
            //System.out.println("Hubo una excepción al actualizar el tipo de usuario " + e.getMessage());
            return TemporalFrequencyResultFactory.UpdateFail();
        }

        //System.out.println("query.getParams(): " + query.getParams().values().toString());
        if (result == 0) {
            return TemporalFrequencyResultFactory.UpdateFail();
        }

        return TemporalFrequencyResultFactory.UpdateSuccess(new TemporalFrequency());

    }

}
