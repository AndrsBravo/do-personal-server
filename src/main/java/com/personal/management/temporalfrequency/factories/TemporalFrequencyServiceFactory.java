package com.personal.management.temporalfrequency.factories;

import com.personal.management.temporalfrequency.create.services.CreateTemporalFrequencyService;
import com.personal.management.temporalfrequency.delete.services.DeleteTemporalFrequencyService;
import com.personal.management.temporalfrequency.filter.services.FilterTemporalFrequencyService;
import com.personal.management.temporalfrequency.update.services.EditTemporalFrequencyService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class TemporalFrequencyServiceFactory {

    public static CreateTemporalFrequencyService CreateTemporalFrequency() {

        return new CreateTemporalFrequencyService(DbClientMSSQLFactory.Management());
    }

    public static FilterTemporalFrequencyService FilterTemporalFrequency() {

        return new FilterTemporalFrequencyService(DbClientMSSQLFactory.Management());
    }

    public static EditTemporalFrequencyService EditTemporalFrequency() {

        return new EditTemporalFrequencyService(DbClientMSSQLFactory.Management());
    }

    public static DeleteTemporalFrequencyService DeleteTemporalFrequency() {

        return new DeleteTemporalFrequencyService(DbClientMSSQLFactory.Management());
    }

}
