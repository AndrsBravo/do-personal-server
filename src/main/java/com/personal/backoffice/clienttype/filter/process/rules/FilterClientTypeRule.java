package com.personal.backoffice.clienttype.filter.process.rules;

import com.personal.backoffice.clienttype.factories.ClientTypeServiceFactory;
import com.personal.backoffice.clienttype.filter.process.FilterClientTypeProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterClientTypeRule implements IProcessRule<FilterClientTypeProcess> {

    @Override
    public void apply(FilterClientTypeProcess process) {

        var pLogger = LogFactory.builder(FilterClientTypeProcess.class, FilterClientTypeRule.class);
        var query = process.Query();
        var clientTypeFilter = process.getInitObject();

        if (clientTypeFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (clientTypeFilter.getId() != null) {
            query.Field("id", clientTypeFilter.getId());
            query.Where().AndEqu("id");
        }

        if (clientTypeFilter.getType() != null) {
            query.Field("ct_type", clientTypeFilter.getType());
            query.Where().AndEqu("ct_type");
        }

        var filterClientType = ClientTypeServiceFactory.FilterClientTypes();

        var result = filterClientType.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
