package com.personal.business.temporalfrequency.factories;

import com.personal.business.temporalfrequency.create.services.CreateTemporalFrequencyService;
import com.personal.business.temporalfrequency.delete.services.DeleteTemporalFrequencyService;
import com.personal.business.temporalfrequency.filter.services.FilterTemporalFrequencyService;
import com.personal.business.temporalfrequency.update.services.EditTemporalFrequencyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class TemporalFrequencyServiceFactory {

    public static CreateTemporalFrequencyService CreateTemporalFrequency(String dbClient) {

        return new CreateTemporalFrequencyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterTemporalFrequencyService FilterTemporalFrequency(String dbClient) {

        return new FilterTemporalFrequencyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditTemporalFrequencyService EditTemporalFrequency(String dbClient) {

        return new EditTemporalFrequencyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteTemporalFrequencyService DeleteTemporalFrequency(String dbClient) {

        return new DeleteTemporalFrequencyService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
