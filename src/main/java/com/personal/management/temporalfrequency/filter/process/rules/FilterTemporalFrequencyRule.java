package com.personal.management.temporalfrequency.filter.process.rules;

import com.personal.management.temporalfrequency.factories.TemporalFrequencyServiceFactory;
import com.personal.management.temporalfrequency.filter.process.FilterTemporalFrequencyProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterTemporalFrequencyRule implements IProcessRule<FilterTemporalFrequencyProcess> {

    @Override
    public void apply(FilterTemporalFrequencyProcess process) {

        var pLogger = LogFactory.builder(FilterTemporalFrequencyProcess.class, FilterTemporalFrequencyRule.class);

        var query = process.Query();

        var temporalFrequency = process.getInitObject();
        if (temporalFrequency.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (temporalFrequency.getId() != null) {
            query.Field("id", temporalFrequency.getId());
            query.Where().AndEqu("id");
        }

        if (temporalFrequency.getType() != null) {
            query.Field("tf_category", temporalFrequency.getType());
            query.Where().AndEqu("tf_category");
        }

        var filterTemporalFrequency = TemporalFrequencyServiceFactory.FilterTemporalFrequency();

        var result = filterTemporalFrequency.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
