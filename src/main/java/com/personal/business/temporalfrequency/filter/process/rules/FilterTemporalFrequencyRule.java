package com.personal.business.temporalfrequency.filter.process.rules;

import com.personal.business.temporalfrequency.factories.TemporalFrequencyServiceFactory;
import com.personal.business.temporalfrequency.filter.process.FilterTemporalFrequencyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterTemporalFrequencyRule implements IProcessRule<FilterTemporalFrequencyProcess> {

    @Override
    public void apply(FilterTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(FilterTemporalFrequencyProcess.class, FilterTemporalFrequencyRule.class);
        var temporalFrequencyFilter = process.getInitObject();

        var query = process.Query();

        if (temporalFrequencyFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (temporalFrequencyFilter.getId() != null) {
            query.Field("id", temporalFrequencyFilter.getId());
            query.Where().AndEqu("id");
        }

        if (temporalFrequencyFilter.getType() != null) {
            query.Field("tf_category", temporalFrequencyFilter.getType());
            query.Where().AndEqu("tf_category");
        }

        var filterTemporalFrequency = TemporalFrequencyServiceFactory.FilterTemporalFrequency(temporalFrequencyFilter.getBusiness().getDbName());

        var result = filterTemporalFrequency.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
