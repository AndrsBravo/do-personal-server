package com.personal.backoffice.client.filter.process.rules;

import com.personal.backoffice.client.factories.ClientServiceFactory;
import com.personal.backoffice.client.filter.process.FilterClientProcess;
import com.personal.shared.process.IProcessRule;
import com.personal.shared.process.logs.LogFactory;

public class FilterClientRule implements IProcessRule<FilterClientProcess> {

    @Override
    public void apply(FilterClientProcess process) {

        var pLogger = LogFactory.builder(FilterClientProcess.class, FilterClientRule.class);
        var query = process.Query();
        var clientFilter = process.getInitObject();

        if (clientFilter.getAll() != null) {
            query.Field("id", "");
            query.Where().AndNotEmpty("id");
        }

        if (clientFilter.getId() != null) {
            query.Field("id", clientFilter.getId());
            query.Where().AndEqu("id");
        }

        if (clientFilter.getType() != null) {
            query.Field("c_types_id", clientFilter.getType());
            query.Where().AndEqu("c_types_id");
        }

        var filterClient = ClientServiceFactory.FilterClients();

        var result = filterClient.filter(query);
        process.setResult(result.getResult());
        process.addLog(pLogger.INFO("Filter User Types", "Filtered user types with properties: " + query.getKeyPair()));
    }

}
